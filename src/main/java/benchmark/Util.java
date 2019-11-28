package benchmark;

import edu.ktu.ds.lab3.cepkauskas.Capacitor;
import edu.ktu.ds.lab3.cepkauskas.CapacitorGenerator;
import edu.ktu.ds.lab3.utils.Map;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Random;
import java.util.stream.Stream;

public class Util {

    static Random random = new Random();
    static String path = "./data/zodynas.txt";





    public static void GenerateMapStr(Map<String, String> map, int size) {

       String[] words;
        try (Stream<String> stream1 = Files.lines(Paths.get(path))) {

            words = stream1
                    .toArray(String[]::new);

            for(int i = 0; i < size; i++){

                map.put(words[i], words[i]);

            }


        } catch (IOException e) {
            e.printStackTrace();
        }




    }

    public static void GenerateMapStrJava(java.util.Map<String, String> map, int size, String[] indices, int size1){

        String[] words;

        try (Stream<String> stream1 = Files.lines(Paths.get(path))) {

            words = stream1
                    .toArray(String[]::new);

            for(int i = 0; i < size; i++){

                map.put(words[i], words[i]);
                if(i < size1){
                    indices[i] = words[i];
                }


            }


        } catch (IOException e) {
            e.printStackTrace();
        }





    }


    public static void GenerateMapCap(Map<String, Capacitor> map, int size){

        for(int i = 0; i < size; i++){
           Capacitor cap = new Capacitor.Builder().buildRandom();
           map.put("ID" + i, cap );

        }


    }
    public static void GenerateMapCapJava(java.util.Map<String, Capacitor> map, int size){
        //Capacitor[] capacitors = CapacitorGenerator.generateShuffleCapacitors(size);
        for(int i = 0; i < size; i++){
            Capacitor cap = new Capacitor.Builder().buildRandom();
            map.put("ID" + i, cap );

        }


    }

    public static void GenerateIndices(String[] indices, int size){
        for(int i = 0; i < indices.length; i++){

          indices[i] = "ID" + random.nextInt(size);

        }

    }





}
