package bcit.comp2601.assignment2.concurrency;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

/**
 * Class: DivideAndConquerSum
 * Implements any one of the code samples at <a href="https://www.zghurskyi.com/concurrent-sum-of-numbers/">...</a>.
 * Instead of putting their main() method code into main(), rename the method "concurrentMain()".
 * Calls concurrentMain() from the menu when the user chooses Type 4 for Concurrency.
 * This class has static varibles which are:
 * - MINIMUM_THREADS = 1
 */
public class DivideAndConquerSum
{
    private static final int MINIMUM_THREADS;

    static
    {
        MINIMUM_THREADS = 1;
    }

    /**
     * sum(int rangeStart, int rangeEnd, int numberOfThreads)
     * Find total threads that found in the range (rangeStart, rangeEnd).
     * @param rangeStart - integer range start
     * @param rangeEnd   - integer range end
     * @param numberOfThreads - integer number of threads
     * @return total threads
     */
    private static int sum(int rangeStart, int rangeEnd, int numberOfThreads)
    {
        ForkJoinPool forkJoinPool = new ForkJoinPool(numberOfThreads);
        try
        {
            return forkJoinPool.submit(() ->
                   IntStream.rangeClosed(rangeStart, rangeEnd)
                           .parallel()
                           .sum()
            ).get();
        }
        catch (InterruptedException | ExecutionException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * concurrentMain()
     * User will need to input rangeStart, rangeEnd, numberOfThreads to find the total threads.
     * If rangeStart is more or equal to rangeEnd, the program will display warning messages and keep asking user until it gets the right number.
     */
    public static void concurrentMain()
    {
        int rangeStart, rangeEnd, numberOfThreads;
        do
        {
            System.out.print("Enter the range start: ");
            rangeStart = new Scanner(System.in).nextInt();

            System.out.print("Enter the range end: ");
            rangeEnd = new Scanner(System.in).nextInt();

            System.out.print("Enter the number of threads: ");
            numberOfThreads = new Scanner(System.in).nextInt();


            if (rangeStart >= rangeEnd || numberOfThreads < MINIMUM_THREADS)
            {
                System.out.println("Warning: range start should be less then range end. Also number of threads should not be less then 1.");
            }
        }
        while (rangeStart >= rangeEnd || numberOfThreads < MINIMUM_THREADS);

        int sum = DivideAndConquerSum.sum(rangeStart, rangeEnd, numberOfThreads);

        System.out.printf("Sum of numbers in the range [%s, %s] found in %s threads is %s%n",
                          rangeStart, rangeEnd, numberOfThreads, sum);

    }
}
