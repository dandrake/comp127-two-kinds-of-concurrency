package paralleldanger;

import java.util.stream.LongStream;

public class SisyphusStream {
    public static void main(String[] args) {
        LongStream.range(0, 100L)
            .map(n -> 1);
    }
}
