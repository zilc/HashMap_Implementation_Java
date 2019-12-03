package edu.ktu.ds.lab3.cepkauskas;
import edu.ktu.ds.lab3.utils.*;

import java.util.Locale;

public class ManualTest {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US); // suvienodiname skaičių formatus
        executeTest();
    }

    public static void executeTest() {
        Capacitor c1 = new Capacitor(80, 50, "Keramikinis", 12, 0.5);
        Capacitor c2 = new Capacitor(25, 50, "Keramikinis", 12, 0.65);
        Capacitor c3 = new Capacitor(72, 55, "Keramikinis", 12, 0.53);
        Capacitor c4 = new Capacitor("1000   65  Elektrolitinis  24 0.3");
        Capacitor c5 = new Capacitor.Builder().buildRandom();
        Capacitor c6 = new Capacitor("500   65  Elektrolitinis  12 0.5");
        Capacitor c7 = new Capacitor("510   50  Plėvelinis  12 0.41");
        Capacitor rplc = new Capacitor("42   60  Keramikinis 12 0.52");
        Capacitor c80 = new Capacitor("300   62  Plėvelinis  12 0.6");
        Capacitor c81 = new Capacitor("125   75  Elektrolitinis  12 0.2");

        Capacitor c8 = new Capacitor.Builder().buildRandom();
        Capacitor c9 = new Capacitor.Builder().buildRandom();
        Capacitor c10 = new Capacitor.Builder().buildRandom();
        Capacitor c11 = new Capacitor.Builder().buildRandom();
        Capacitor c12= new Capacitor.Builder().buildRandom();
        Capacitor c13= new Capacitor.Builder().buildRandom();
        Capacitor c14 = new Capacitor.Builder().buildRandom();
        Capacitor c15 = new Capacitor.Builder().buildRandom();
        Capacitor c16 = new Capacitor.Builder().buildRandom();
        Capacitor c17 = new Capacitor.Builder().buildRandom();
        Capacitor c18= new Capacitor.Builder().buildRandom();
        Capacitor c19 = new Capacitor.Builder().buildRandom();
        Capacitor c20 = new Capacitor.Builder().buildRandom();
        Capacitor c21 = new Capacitor.Builder().buildRandom();
        Capacitor c22 = new Capacitor.Builder().buildRandom();

        // Raktų masyvas

        String[] capIds = {"ID156", "ID102", "ID178", "ID171", "ID105", "ID106", "ID107", "ID108"};
        String[] capIds1 = {"ID156", "ID102", "ID178", "ID178", "ID105", "ID106", "ID107", "ID108","ID111", "ID222"
                ,"ID333","ID359","ID100","ID908","ID198"};

        String[] capIds2 = {"ID156", "ID156", "ID178", "ID178", "ID105", "ID105", "ID107", "ID107","ID111", "ID111"
                ,"ID333","ID333","ID100","ID100","ID198", "ID198", "ID202", "ID202", "ID203", "ID203", "ID202",
                "ID207", "ID207"} ;
        int id = 0;

        HashMapOa<String, Capacitor> capHashMap = new HashMapOa<>( HashType.DIVISION);
        ParsableMap<String, Capacitor> capMap
                = new ParsableHashMap<>(String::new, Capacitor::new, HashType.DIVISION);

        ParsableMap<String, Capacitor> capsMap1
                = new ParsableHashMap<>(String::new, Capacitor::new, HashType.DIVISION);

        ParsableMap<String, Capacitor> capsMap2
                = new ParsableHashMap<>(String::new, Capacitor::new, HashType.DIVISION);


        // Reikšmių masyvas
        Capacitor[] cars0 = {c1, c2, c3, c4, c5,c7,c6};
        for (Capacitor c : cars0) {
            capHashMap.put(capIds[id++], c);
        }
        Ks.oun(capHashMap);
        Ks.oun("get" + capIds[4]);
        Ks.oun(capHashMap.get(capIds[4]));
        Ks.oun("------------------------------");
        Ks.oun("remove");
        Ks.oun(capHashMap.remove(capIds[4]));
        Ks.oun(capHashMap);

        Ks.oun("put");
        capHashMap.put("ID179999",c80);
        capHashMap.put("ID189999",c81);
        capHashMap.put("ID103",c2);
        capHashMap.put("ID133",c11);
        capHashMap.put("ID153",c14);
        capHashMap.put("ID253",c12);
        capHashMap.put("ID137",c2);
        capHashMap.put("ID100",c18);
        capHashMap.put("ID117",c7);
        capHashMap.put("ID107",c5);
        capHashMap.put("ID123",c6);




        Ks.oun(capHashMap);
        Ks.oun("get");
        Ks.oun(capHashMap.get("ID171"));




        id = 0;

        Capacitor[] capacitors = {c1, c2, c3, c4, c5,c7,c6};
        for (Capacitor c : capacitors) {
            capMap.put(capIds[id++], c);
        }
        Ks.oun(capMap);
        Ks.oun("get");




        id = 0;

        Capacitor[] capacitors1 = {c8, c9, c10, c11, c12,c13,c14, c15, c16, c17, c18, c19,c20,c21,c22};
        for (Capacitor c : capacitors1) {
            capsMap1.put(capIds1[id++], c);
        }
        id = 0;

        Capacitor[] capacitors2 = {c1, c2, c3, c4, c5,c7,c6,c8, c9, c10, c11, c12,c13,c14, c15, c16, c17, c18, c19,c20,c21,c22};
        for (Capacitor c : capacitors2) {
            capsMap2.put(capIds2[id++], c);
        }
        id = 0;


        Ks.ounn(capMap);
        Ks.oun("average chain size" +((HashMap)capMap).averageChainSize());
        Ks.ounn(capsMap1);

        Ks.oun("average chain size" +((HashMap)capsMap1).averageChainSize());

        Ks.ounn(capsMap2);

        Ks.oun("average chain size" +((HashMap)capsMap2).averageChainSize());


        Ks.ounn(capMap);
        Ks.oun("Replace: " + ((HashMap)capMap).get(capIds[0])+ "with: " + rplc);
        ((HashMap)capMap).replace(capIds[0], ((HashMap)capMap).get(capIds[0]),rplc);
        Ks.ounn(capMap);
        Ks.ounn("XXXXXXXXXXXXX");
        Ks.ounn(capsMap2);
        Ks.oun("Replace: " + ((HashMap)capsMap2).get(capIds2[18])+ "with: " + rplc);
         ((HashMap)capsMap2).replace(capIds2[18],((HashMap)capsMap2).get(capIds2[18]),rplc);

        Ks.ounn(capsMap2);
        Ks.oun("numb of empties");
        Ks.oun(((HashMap)capMap).numberOfEmpties());
        for(int i = 0; i < capacitors.length; i++){
            Ks.oun("Contains value" + capacitors[i]);
            Ks.oun(((HashMap)capMap).containsValue(capacitors[i]));
        }
        Ks.oun("Contains value" + c6);
          Ks.oun(((HashMap)capMap).containsValue(c6));
        capMap.println("Porų išsidėstymas atvaizdyje pagal raktus");
        Ks.oun("Ar egzistuoja pora atvaizdyje?");
        Ks.oun(capMap.contains(capIds[6]));
        Ks.oun(capMap.contains(capIds[7]));
        Ks.oun("Pašalinamos poros iš atvaizdžio:");
        Ks.oun(capMap.remove(capIds[1]));
        Ks.oun(capMap.remove(capIds[7]));
        capMap.println("Porų išsidėstymas atvaizdyje pagal raktus");
        Ks.oun("Atliekame porų paiešką atvaizdyje:");
        Ks.oun(capMap.get(capIds[2]));
        Ks.oun(capMap.get(capIds[7]));
        Ks.oun("Išspausdiname atvaizdžio poras String eilute:");
        Ks.ounn(capMap);
    }
}
