package HotterColder;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class DoublingTest {
    private static final int MAXIMUM_INTEGER = 1000000;

    // This class should not be instantiated.
    private DoublingTest() { }

    public static double timeTrial(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = StdRandom.uniformInt(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
        }
        Stopwatch timer = new Stopwatch();
        for (int each : array) {
            int ignore = HotterColder.guessSecretNumber(each);
        }
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        for (int n = 250; true; n += n) {
            double time = timeTrial(n);
            StdOut.printf("%7d %7.4f\n", n, time);
        }


    }
}