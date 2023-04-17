package SortingAlgorithms;

public class QuicksortV2 {

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo + 10) {
             InsertionSort.sort(a, lo, hi);
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int pivotIndex = choosePivot(a, lo, hi);
        exch(a, pivotIndex, lo); // move pivot to beginning
        Comparable v = a[lo];
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static int choosePivot(Comparable[] a, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        if (less(a[mid], a[lo])) {
            exch(a, lo, mid);
        }
        if (less(a[hi], a[lo])) {
            exch(a, lo, hi);
        }
        if (less(a[hi], a[mid])) {
            exch(a, mid, hi);
        }
        return mid;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a1 = {"Jacob", "Laine", "Josh", "Charlie", "Trent"};
        sort(a1);
        assert isSorted(a1) : "a1 is NOT sorted.";
        show(a1);

        Integer[] a2 = {3, 1, 4, 1, 5, 9, 2};
        sort(a2);
        assert isSorted(a2) : "a2 is NOT sorted.";
        show(a2);
    }
}
