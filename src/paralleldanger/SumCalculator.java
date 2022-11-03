package paralleldanger;

/**
 * Calculates the sum of an arbitrary number of longs.
 */
public class SumCalculator {
    private long total;

    /**
     * Adds the given number to the running total.
     */
    public void add(long x) {
        total += x;
    }

    /**
     * Returns to total so far.
     */
    public long getTotal() {
        return total;
    }
}
