package Josephus;

import java.util.LinkedList;
import java.util.Queue;

public class Josephus {
    public static void Josephus(int M, int N) {
        int[] intArray = new int[N];
        for (int i = 0; i < N; i++) {
            intArray[i] = i + 1;
        }
        int arrayIndex = 0;
        Queue<Integer> finalQueue = new LinkedList<Integer>();
        while (intArray.length != 0) {
            arrayIndex = (arrayIndex + M - 1) % intArray.length;
            int killed = intArray[arrayIndex];
            int[] newIntArray = new int[intArray.length - 1];
            for (int i = 0, j = 0; i < intArray.length; i++) {
                if (intArray[i] != killed) {
                    newIntArray[j++] = intArray[i];
                }
            }
            intArray = newIntArray;
            finalQueue.offer(killed);
        }
        while (!finalQueue.isEmpty()) {
            System.out.print(finalQueue.poll() + " ");
        }
    }

    public static void main(String[] args) {
        Josephus(3, 7);
    }

}
