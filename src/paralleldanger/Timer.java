package paralleldanger;

import java.util.DoubleSummaryStatistics;
import java.util.stream.IntStream;

/**
 * Utility for gathering simple performance statistics.
 */
public class Timer {
    /**
     * Repeats the given closure, measuring and printing the time elapsed for each repetition,
     * then printing the average time at the end.
     * 
     * @param repetitions Number of times to repeat the task
     * @param task        Task to be timed
     */
    public static void measure(int repetitions, Runnable task) {
        DoubleSummaryStatistics stats =
            IntStream.range(0, repetitions)
                .mapToDouble(rep ->  {
                    long start = System.nanoTime();
                    task.run();
                    double elapsed = (System.nanoTime() - start) / 1_000_000_000.0;
                    System.out.printf("Elapsed time: %1.3f seconds (rep #%d)\n", elapsed, rep);
                    return elapsed;
                })
                .summaryStatistics();
        System.out.printf(
            """
            
            Average: %3.4f sec
                Min: %3.3f  sec
                Max: %3.3f  sec
            
            (%d repetitions)

            """,
            stats.getAverage(),
            stats.getMin(),
            stats.getMax(),
            stats.getCount());
    }
}
