package benchmark;

import edu.ktu.ds.lab3.cepkauskas.Capacitor;
import edu.ktu.ds.lab3.cepkauskas.CapacitorGenerator;
import edu.ktu.ds.lab3.utils.HashMap;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;



@BenchmarkMode(Mode.AverageTime)
@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(time = 1, timeUnit = TimeUnit.SECONDS)


public class JmhBenchmark {

    static final int OPERATION_COUNT = 1_000;

    @Param({"4000", "8000", "16000", "32000"})
    public int size;

    Capacitor[] capacitors;
    HashMap<String, String> hashMapCustomStr = new HashMap<>();
    java.util.HashMap<String, String> hashMapJavaStr = new java.util.HashMap<>();

    HashMap<String, Capacitor> hashMapCustomCap = new HashMap<>();
    java.util.HashMap<String, Capacitor> hashMapJavaCap = new java.util.HashMap<>();
    String[] indexesSTR = new String[OPERATION_COUNT];
    String[] indexesCAP = new String[OPERATION_COUNT];


    @Setup(Level.Trial)
    public void generateHashMaps() throws FileNotFoundException {



        capacitors = new CapacitorGenerator().generateShuffleCapacitors(OPERATION_COUNT);
        Util.GenerateMapStrJava(hashMapJavaStr, size, indexesSTR, OPERATION_COUNT);
        Util.GenerateMapStr(hashMapCustomStr, size);


        Util.GenerateMapCap(hashMapCustomCap,size);
        Util.GenerateMapCapJava(hashMapJavaCap,size);


    }

    @Setup(Level.Iteration)
    public void generateIndices(){
        Util.GenerateIndices(indexesCAP, size);
    }

    @Benchmark
    public void hashMapStrRemoveCustom(Blackhole bh){hMapStrRemoveCustom(hashMapCustomStr, bh );}
    @Benchmark
    public void hashMapStrRemoveJava(Blackhole bh){hMapStrRemoveJava(hashMapJavaStr, bh );}

    @Benchmark
    public void hashMapCapRemove(Blackhole bh){hMapCapRemoveCustom(hashMapCustomCap,  bh);}

    @Benchmark
    public void hashMapCapJavaRemove(Blackhole bh){hMapCapRemoveJava(hashMapJavaCap,  bh);}

    private void hMapStrRemoveCustom(HashMap map, Blackhole bh){
        for(String str : indexesSTR ){
           bh.consume(map.remove(str));
        }
    }

    private void hMapStrRemoveJava(java.util.HashMap map, Blackhole bh){
        for(String str : indexesSTR ){
            bh.consume(map.remove(str));
        }
    }

    private void hMapCapRemoveCustom(HashMap map, Blackhole bh){
        for(String str : indexesCAP ){
            bh.consume(map.remove(str));
        }
    }

    private void hMapCapRemoveJava(java.util.HashMap map, Blackhole bh){
        for(String str : indexesCAP ){
            bh.consume(map.remove(str));
        }
    }

    @Benchmark
    public void hashMapStrContainsCustom(Blackhole bh){hMapStrContainsCustom(hashMapCustomStr, bh );}
    @Benchmark
    public void hashMapStrContainsJava(Blackhole bh){hMapStrContainsJava(hashMapJavaStr, bh );}

    @Benchmark
    public void hashMapCapContains(Blackhole bh){hMapCapContainsCustom(hashMapCustomCap,  bh);}

    @Benchmark
    public void hashMapCapJavaContains(Blackhole bh){hMapCapContainsJava(hashMapJavaCap,  bh);}

    private void hMapStrContainsCustom(HashMap map, Blackhole bh){
        for(String str : indexesSTR ){
            bh.consume(map.containsValue(str));

        }
    }

    private void hMapStrContainsJava(java.util.HashMap map, Blackhole bh){
        for(String str : indexesSTR ){
            bh.consume(map.containsValue(str));

        }
    }

    private void hMapCapContainsCustom(HashMap map, Blackhole bh){
        for(Capacitor cap : capacitors ){
            bh.consume(map.containsValue(cap));

        }
    }

    private void hMapCapContainsJava(java.util.HashMap map, Blackhole bh){
        for(Capacitor cap : capacitors ){
            bh.consume(map.containsValue(cap));

        }
    }





    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JmhBenchmark.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }

}
