package edu.ktu.ds.lab3.demo;

import edu.ktu.ds.lab3.utils.*;

import java.util.Locale;

import java.util.Locale;

public class ManualTest {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US); // suvienodiname skaičių formatus
        executeTest();
    }

    public static void executeTest() {
        Car c1 = new Car("Renault", "Laguna", 1997, 50000, 1700);
        Car c2 = new Car("Renault", "Megane", 2001, 20000, 3500);
        Car c3 = new Car("Toyota", "Corolla", 2001, 20000, 8500.8);
        Car c4 = new Car("Renault Laguna 2001 115900 7500");
        Car c5 = new Car.Builder().buildRandom();
        Car c6 = new Car("Honda   Civic  2007  36400 8500.3");
        Car c7 = new Car("Renault Laguna 2001 115900 7500");
        Car rplc = new Car("Mitsubishi Lancer 2011 11500 75000");

        Car c8 = new Car.Builder().buildRandom();
        Car c9 = new Car.Builder().buildRandom();
        Car c10 = new Car.Builder().buildRandom();
        Car c11 = new Car.Builder().buildRandom();
        Car c12= new Car.Builder().buildRandom();
        Car c13= new Car.Builder().buildRandom();
        Car c14 = new Car.Builder().buildRandom();
        Car c15 = new Car.Builder().buildRandom();
        Car c16 = new Car.Builder().buildRandom();
        Car c17 = new Car.Builder().buildRandom();
        Car c18= new Car.Builder().buildRandom();
        Car c19 = new Car.Builder().buildRandom();
        Car c20 = new Car.Builder().buildRandom();
        Car c21 = new Car.Builder().buildRandom();
        Car c22 = new Car.Builder().buildRandom();

        // Raktų masyvas
        String[] carsIds = {"TA156", "TA102", "TA178", "TA171", "TA105", "TA106", "TA107", "TA108"};
        String[] carsIds1 = {"TA156", "TA102", "TA178", "TA178", "TA105", "TA106", "TA107", "TA108","TA111", "TA222","TA333","TA359","TA100","TA908","TA198"};

        String[] carsIds2 = {"TA156", "TA156", "TA178", "TA178", "TA105", "TA105", "TA107", "TA107","TA111", "TA111","TA333","TA333","TA100","TA100","TA198", "TA198", "TA202", "TA202", "TA203", "TA203", "TA202", "TA207", "TA207"} ;
        int id = 0;
        ParsableMap<String, Car> carsMap
                = new ParsableHashMap<>(String::new, Car::new, HashType.DIVISION);

        ParsableMap<String, Car> carsMap1
                = new ParsableHashMap<>(String::new, Car::new, HashType.DIVISION);

        ParsableMap<String, Car> carsMap2
                = new ParsableHashMap<>(String::new, Car::new, HashType.DIVISION);


        // Reikšmių masyvas
        Car[] cars = {c1, c2, c3, c4, c5,c7,c6};
        for (Car c : cars) {
            carsMap.put(carsIds[id++], c);
        }
        id = 0;

        Car[] cars1 = {c8, c9, c10, c11, c12,c13,c14, c15, c16, c17, c18, c19,c20,c21,c22};
        for (Car c : cars1) {
            carsMap1.put(carsIds1[id++], c);
        }
        id = 0;

        Car[] cars2 = {c1, c2, c3, c4, c5,c7,c6,c8, c9, c10, c11, c12,c13,c14, c15, c16, c17, c18, c19,c20,c21,c22};
        for (Car c : cars2) {
            carsMap2.put(carsIds2[id++], c);
        }
        id = 0;


        Ks.ounn(carsMap);
        Ks.oun("average chain size" +((HashMap)carsMap).averageChainSize());
        Ks.ounn(carsMap1);

        Ks.oun("average chain size" +((HashMap)carsMap1).averageChainSize());

        Ks.ounn(carsMap2);

        Ks.oun("average chain size" +((HashMap)carsMap2).averageChainSize());


        Ks.ounn(carsMap);
        Ks.oun("Replace: " + ((HashMap)carsMap).get(carsIds[0])+ "with: " + rplc);
        ((HashMap)carsMap).replace(carsIds[0], ((HashMap)carsMap).get(carsIds[0]),rplc);
        Ks.ounn(carsMap);
        Ks.ounn("XXXXXXXXXXXXX");
        Ks.ounn(carsMap2);
        Ks.oun("Replace: " + ((HashMap)carsMap2).get(carsIds2[18])+ "with: " + rplc);
         ((HashMap)carsMap2).replace(carsIds2[18],((HashMap)carsMap2).get(carsIds2[18]),rplc);

        Ks.ounn(carsMap2);
        Ks.oun("numb of empties");
        Ks.oun(((HashMap)carsMap).numberOfEmpties());
        for(int i = 0; i < cars.length; i++){
            Ks.oun("Contains value" + cars[i]);
            //     Ks.oun(((HashMap)carsMap).containsValue(cars[i]));
        }
        Ks.oun("Contains value" + c6);
        //   Ks.oun(((HashMap)carsMap).containsValue(c6));
        carsMap.println("Porų išsidėstymas atvaizdyje pagal raktus");
        Ks.oun("Ar egzistuoja pora atvaizdyje?");
        Ks.oun(carsMap.contains(carsIds[6]));
        Ks.oun(carsMap.contains(carsIds[7]));
        Ks.oun("Pašalinamos poros iš atvaizdžio:");
        Ks.oun(carsMap.remove(carsIds[1]));
        Ks.oun(carsMap.remove(carsIds[7]));
        carsMap.println("Porų išsidėstymas atvaizdyje pagal raktus");
        Ks.oun("Atliekame porų paiešką atvaizdyje:");
        Ks.oun(carsMap.get(carsIds[2]));
        Ks.oun(carsMap.get(carsIds[7]));
        Ks.oun("Išspausdiname atvaizdžio poras String eilute:");
        Ks.ounn(carsMap);
    }
}
