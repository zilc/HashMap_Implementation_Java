package edu.ktu.ds.lab3.cepkauskas;

import edu.ktu.ds.lab3.gui.ValidationException;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class CapacitorGenerator {

    private static final String ID_CODE = "ID";      //  ***** Nauja
    private static int serNr = 10000;               //  ***** Nauja

    private Capacitor[] capacitors;
    private String[] keys;

    private int currCapacitorIndex = 0, currCapacitorIdIndex = 0;

    public static Capacitor[] generateShuffleCapacitors(int size) {
        Capacitor[] cars = IntStream.range(0, size)
                .mapToObj(i -> new Capacitor.Builder().buildRandom())
                .toArray(Capacitor[]::new);
        Collections.shuffle(Arrays.asList(cars));
        return cars;
    }

    public static String[] generateShuffleIds(int size) {
        String[] keys = IntStream.range(0, size)
                .mapToObj(i -> ID_CODE + (serNr++))
                .toArray(String[]::new);
        Collections.shuffle(Arrays.asList(keys));
        return keys;
    }

    public Capacitor[] generateShuffleCapacitorsAndIds(int setSize,
                                                       int setTakeSize) throws ValidationException {

        if (setTakeSize > setSize) {
            setTakeSize = setSize;
        }
        capacitors = generateShuffleCapacitors(setSize);
        keys = generateShuffleIds(setSize);
        this.currCapacitorIndex = setTakeSize;
        return Arrays.copyOf(capacitors, setTakeSize);
    }

    // Imamas po vienas elementas iš sugeneruoto masyvo. Kai elementai baigiasi sugeneruojama
    // nuosava situacija ir išmetamas pranešimas.
    public Capacitor getCapacitor() {
        if (capacitors == null) {
            throw new ValidationException("capacitorsNotGenerated");
        }
        if (currCapacitorIndex < capacitors.length) {
            return capacitors[currCapacitorIndex++];
        } else {
            throw new ValidationException("allSetStoredToMap");
        }
    }

    public String getCapacitorId() {
        if (keys == null) {
            throw new ValidationException("capacitorsIdsNotGenerated");
        }
        if (currCapacitorIdIndex < keys.length) {
            return keys[currCapacitorIdIndex++];
        } else {
            throw new ValidationException("allKeysStoredToMap");
        }
    }
}
