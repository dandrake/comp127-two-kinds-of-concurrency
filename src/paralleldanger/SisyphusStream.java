package paralleldanger;

import java.util.stream.LongStream;

public class SisyphusStream {
    public static void main(String[] args) {


        Timer.measure(20, () -> {


            // totally broken, non-thread-safe

            // SumCalculator calc = new SumCalculator();
            // LongStream.range(0, 40000000000L)
            // .parallel()
            // .map(n -> 1)
            // .forEach(calc::add);


            long total = LongStream.range(0, 40000000000L)
                .parallel()
                .map(n -> 1)
                .sum();

            System.out.println("total: " + total);
        });

        // System.out.println(calc.getTotal());

    }
}
