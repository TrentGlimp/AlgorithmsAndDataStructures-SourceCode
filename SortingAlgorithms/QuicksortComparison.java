package SortingAlgorithms;

import java.text.DecimalFormat;

public class QuicksortComparison {
    public static void main(String[] args) {
        int n = 2500;
        int maxN = 100000000; // Adjust maxN as needed
        long startTime, endTime;

        while (n <= maxN) {
            Integer[] a = new Integer[n];
            Integer[] b = new Integer[n];
            Integer[] c = new Integer[n];
            Integer[] d = new Integer[n];

            for (int i = 0; i < n; i++) {
                int value = (int) (Math.random() * n);
                a[i] = value;
                b[i] = value;
                c[i] = value;
                d[i] = value;
            }

            // Quicksort
            startTime = System.nanoTime();
            QuicksortV1.sort(a);
            endTime = System.nanoTime();
            double time1 = (endTime - startTime) / 1_000_000_000.0;

            // QuicksortMedian3
            startTime = System.nanoTime();
            QuicksortV2.sort(b);
            endTime = System.nanoTime();
            double time2 = (endTime - startTime) / 1_000_000_000.0;

            // Quicksort3Way
            startTime = System.nanoTime();
            QuicksortV3.sort(c);
            endTime = System.nanoTime();
            double time3 = (endTime - startTime) / 1_000_000_000.0;

            // QuicksortMedian5
            startTime = System.nanoTime();
            QuicksortVFinal.sort(d);
            endTime = System.nanoTime();
            double time4 = (endTime - startTime) / 1_000_000_000.0;

            DecimalFormat df = new DecimalFormat("#.##");
            System.out.println(n + ":   " + df.format(time1) + "s   " + df.format(time2) + "s   " + df.format(time3) + "s   " + df.format(time4) + "s");

            n *= 2;
        }
    }
}
