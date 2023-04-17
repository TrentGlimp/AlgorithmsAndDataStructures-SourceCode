package SortingAlgorithms;

public class InsertionSort {

    public static void sort(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            Comparable key = a[i];
            int j = i - 1;
            while (j >= lo && a[j].compareTo(key) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
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
        sort(a1, 0, a1.length - 1);
        assert isSorted(a1) : "a1 is NOT sorted.";
        show(a1);

        Integer[] a2 = {3, 1, 4, 1, 5, 9, 2};
        sort(a2, 0, a2.length - 1);
        assert isSorted(a2) : "a2 is NOT sorted.";
        show(a2);
    }
}
