package Josephus;

import java.util.LinkedList;
import java.util.Queue;

public class Josephus {
    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.add(i);
        }

        int count = 0;
        System.out.print("Killed in order: ");
        while (queue.size() > 1) {
            int killed = queue.remove();
            count++;
            if (count % M == 0) {
                System.out.print(killed + " ");
            } else {
                queue.add(killed);
            }
        }

        System.out.println("\nSurviving position: " + queue.remove());
    }
}


// Sample CLI input/output

// java Josephus.java 4 7

// Killed in order: 3 0 5 4 6 2
// Surviving position: 1