package edu.ktu.ds.lab3.cepkauskas;


import edu.ktu.ds.lab3.utils.Ks;
import edu.ktu.ds.lab3.utils.Parsable;

import java.util.*;

/**
 *
 * @author zilvinas
 */
public class Capacitor implements Parsable<Capacitor> {

    final static private double minPrice = 0.01;
    final static private double maxPrice = 100.0;

    private double capacity;
    private double temperature;
    private String type;
    private double voltage;
    private double price;


    public Capacitor(){

    }

    public Capacitor(String data){
        parse(data);


    }

    public Capacitor(double cap, double temp, String type, double volt,
                     double price){
        this.capacity = cap;
        this.temperature = temp;
        this.type = type;
        this.voltage = volt;
        this.price = price;


    }

    public Capacitor(Builder builder) {

        this.capacity = builder.capacity ;
        this.temperature = builder.temperature;
        this.type = builder.type;
        this.voltage = builder.voltage;
        this.price = builder.price;
        validate();
    }


    public int compareTo(Capacitor other) {
        // lyginame pagal svarbiausią požymį - kainą
        double otherPrice = other.getPrice();
        if (price < otherPrice) {
            return -1;
        }
        if (price > otherPrice) {
            return +1;
        }
        return 0;
    }

    @Override
    public final void parse(String data){
        try {
            Scanner ed = new Scanner(data);
            capacity =  ed.nextDouble();
            temperature = ed.nextDouble();
            type = ed.next();
            voltage = ed.nextDouble();
            setPrice(ed.nextDouble());
        } catch (InputMismatchException e) {
            Ks.ern("Blogas duomenų formatas apie kondensatorių -> " + data);
        } catch (NoSuchElementException e) {
            Ks.ern("Trūksta duomenų apie kondensatorių -> " + data);
        }



    }


    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public double getCapacity() {
        return this.capacity;
    }

    public double getTemperature() {
        return this.temperature;
    }

    public String getType() {
        return this.type;
    }

    public double getVoltage() {
        return this.voltage;
    }


    @Override
    public String toString() {  // surenkama visa reikalinga informacija
        return String.format("Talpa: %8.1f uF, Temp: %8.1f C, Tipas: %-4s "
                        + "Įtampa: "
                        + "%7.1f V Kaina: %8.2f%s eur",
                capacity, temperature, type, voltage, price, validate());
    }

    public String validate() {
        String error = "";

        if (price < minPrice || price > maxPrice) {
            error += " Kaina už leistinų ribų [" + minPrice
                    + ":" + maxPrice + "]";
        }
        return error;
    }








    public final static Comparator<Capacitor> byCapacityAndPrice
            = Comparator.comparingDouble((Capacitor cap) -> (Double) cap.getCapacity()).thenComparingDouble(cap -> (Double) cap.getPrice());

    public final static Comparator byPrice = (Comparator)
            (Object obj1, Object obj2) -> {
                double price1 = ((Capacitor) obj1).getPrice();
                double price2 = ((Capacitor) obj2).getPrice();
                // didėjanti tvarka, pradedant nuo mažiausios
                if (price1 < price2) {
                    return -1;
                }
                if (price1 > price2) {
                    return 1;
                }
                return 0;
            }
            ;



    public final static Comparator byTypeAndCapacity = (Comparator)
            (Object obj1, Object obj2) -> {
                Capacitor c1 = (Capacitor) obj1;
                Capacitor c2 = (Capacitor) obj2;
                //Type mažėjančia tvarka, esant vienodiems lyginama capacity
                int type1 = c1.getType().compareTo(c2.getType());
                if (type1 != 0) {
                    return type1;
                } else if(c1.getCapacity() < c2.getCapacity()) {
                    return 1;
                }
                else
                if (c1.getCapacity() > c2.getCapacity()) {
                    return -1;
                }
                return 0;
            } ;




    public static void main(String... args) {
        // suvienodiname skaičių formatus pagal LT lokalę (10-ainis kablelis)
        Locale.setDefault(new Locale("LT"));
        Capacitor a1 = new Capacitor(50, 80, "Elektrolitinis", 12, 0.3);
        Capacitor a2 = new Capacitor(300, 50, "Elektrolitinis", 12, 0.6);
        Capacitor a3 = new Capacitor(5, 40, "Keramikinis", 4, 1.0);

        Capacitor a4 = new Capacitor();

        a4.parse("10, 50, Plevelinis, 8, 1,1");
        Ks.oun(a1);
        Ks.oun(a2);
        Ks.oun(a3);
        Ks.oun(a4);
    }


    // Car klases objektų gamintojas (builder'is)
    public static class Builder {

        private final static Random RANDOM = new Random(1949);  // Atsitiktinių generatorius
        private final static String[] MODELS = {"Keramikinis", "Plėvelinis","Elektrolitinis"};



        private double capacity;
        private double temperature;
        private String type;
        private double voltage;
        private double price;

        public Capacitor build() {
            return new Capacitor(this);
        }

        public Capacitor buildRandom() {
            int ma = RANDOM.nextInt(MODELS.length);

            return new Capacitor(2 + RANDOM.nextDouble(), 6 + RANDOM.nextInt(80),MODELS[ma],
                    3 + RANDOM.nextInt(20),
                    0.5 + RANDOM.nextDouble());

        }

        public Builder capacity(int capac) {
            this.capacity = capac;
            return this;
        }

        public Builder temperature(double temp) {
            this.temperature = temp;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder voltage(int voltage) {
            this.voltage = voltage;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }
    }




}

