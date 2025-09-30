package paralleldanger;

import java.util.stream.LongStream;

public class SisyphusStream {
    public static void main(String[] args) {


        Timer.measure(20, () -> {
        SumCalculator calc = new SumCalculator();

        LongStream.range(0, 10000000000L)
            .map(n -> 1)
            .forEach(calc::add);});

        //System.out.println(calc.getTotal());
        
    }
}
