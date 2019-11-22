package edu.ktu.ds.lab3.cepkauskas;

import edu.ktu.ds.lab3.gui.ValidationException;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CapacitorGenerator {

        private int startIndex = 0, lastIndex = 0;
        private boolean isStart = true;

        private Capacitor[] capacitors;

        public Capacitor[] generateShuffle(int setSize,
                                           double shuffleCoef) throws ValidationException {

            return generateShuffle(setSize, setSize, shuffleCoef);
        }

        /**
         * @param setSize
         * @param setTake
         * @param shuffleCoef
         * @return Gražinamas aibesImtis ilgio masyvas
         * @throws ValidationException
         */
        public Capacitor[] generateShuffle(int setSize,
                                           int setTake,
                                           double shuffleCoef) throws ValidationException {

            Capacitor[] capacitors = IntStream.range(0, setSize)
                    .mapToObj(i -> new Capacitor.Builder().buildRandom())
                    .toArray(Capacitor[]::new);
            return shuffle(capacitors, setTake, shuffleCoef);
        }

        public Capacitor takeCapacitor() throws ValidationException {
            if (lastIndex < startIndex) {
                throw new ValidationException(String.valueOf(lastIndex - startIndex), 4);
            }
            // Vieną kartą Automobilis imamas iš masyvo pradžios, kitą kartą - iš galo.
            isStart = !isStart;
            return capacitors[isStart ? startIndex++ : lastIndex--];
        }

        private Capacitor[] shuffle(Capacitor[] capacitors, int amountToReturn, double shuffleCoef) throws ValidationException {
            if (capacitors == null) {
                throw new IllegalArgumentException("Kondensatorių nėra (null)");
            }
            if (amountToReturn <= 0) {
                throw new ValidationException(String.valueOf(amountToReturn), 1);
            }
            if (capacitors.length < amountToReturn) {
                throw new ValidationException(capacitors.length + " >= " + amountToReturn, 2);
            }
            if ((shuffleCoef < 0) || (shuffleCoef > 1)) {
                throw new ValidationException(String.valueOf(shuffleCoef), 3);
            }

            int amountToLeave = capacitors.length - amountToReturn;
            int startIndex = (int) (amountToLeave * shuffleCoef / 2);

            Capacitor[] takeToReturn = Arrays.copyOfRange(capacitors, startIndex, startIndex + amountToReturn);
            Capacitor[] takeToLeave = Stream
                    .concat(Arrays.stream(Arrays.copyOfRange(capacitors, 0, startIndex)),
                            Arrays.stream(Arrays.copyOfRange(capacitors, startIndex + amountToReturn, capacitors.length)))
                    .toArray(Capacitor[]::new);

            Collections.shuffle(Arrays.asList(takeToReturn)
                    .subList(0, (int) (takeToReturn.length * shuffleCoef)));
            Collections.shuffle(Arrays.asList(takeToLeave)
                    .subList(0, (int) (takeToLeave.length * shuffleCoef)));

            this.startIndex = 0;
            this.lastIndex = takeToLeave.length - 1;
            this.capacitors = takeToLeave;
            return takeToReturn;
        }
    }

