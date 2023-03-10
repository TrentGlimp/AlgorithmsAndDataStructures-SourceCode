package HotterColder;

import java.util.Random;
import java.util.Scanner;

public class HotterColder {
    private static int secretNumber;
    private static int prevGuess = 1;
    private static int guessCounter;

    public static String checkGuess(int guess) {
        guessCounter++;
        if (guess == secretNumber) {
            return "number guessed";
        } else if (Math.abs(guess - secretNumber) < Math.abs(prevGuess - secretNumber)) {
            return "hotter";
        } else if (Math.abs(guess - secretNumber) > Math.abs(prevGuess - secretNumber)) {
            return "colder";
        } else {
            return "equal temp";
        }
    }

    public static int guessSecretNumber(int N) {
        int low = 1;
        int high = N;
        int mid = (low + high) / 2;
        String result = checkGuess(mid);

        //System.out.println("Starting the guessing game with a range of 1 to " + N);
        //System.out.println("Initial guess: " + mid);

        while (!result.equals("number guessed")) {
            if (result.equals("equal temp")) {
                //System.out.println("The number has been found! The guess was equal to the secret number.");
                return (prevGuess + mid) / 2;
            }
            prevGuess = mid;
            if (result.equals("hotter")) {
                if (checkGuess(mid+1).equals("hotter") || checkGuess(mid+1).equals("number guessed")) {
                    low = mid + 1;
                    //System.out.println("The guess is getting hotter!\nThe new bounds are [" + low + ", " + high + "]");
                } else {
                    high = mid - 1;
                    //System.out.println("The guess is getting hotter!\nThe new bounds are [" + low + ", " + high + "]");
                }
            } else if (result.equals("colder")) {
                if (checkGuess(mid+1).equals("colder") || checkGuess(mid+1).equals("number guessed")) {
                    high = mid - 1;
                    //System.out.println("The guess is getting colder!\nThe new bounds are [" + low + ", " + high + "]");
                } else {
                    low = mid + 1;
                    //System.out.println("The guess is getting colder!\nThe new bounds are [" + low + ", " + high + "]");
                }
            }

            mid = (high + low) / 2;
            result = checkGuess(mid);

            //System.out.println("New guess: " + mid);
        }

        //System.out.println("The number has been found! It was " + mid);
        return mid;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter A Number 'N': ");
        int N = sc.nextInt();
        sc.close();

        int countCorrect = 0;
        float guessAvg = 0;
        for (int i = 1; i <= N; i++) {
            secretNumber = i;
            guessCounter = 0;
            prevGuess = 1;
            int guess = guessSecretNumber(N);
            if (guess == secretNumber) {
                countCorrect++;
            }
            guessAvg += guessCounter;
        }
        guessAvg = guessAvg/N;
        System.out.println("Number of correct guesses: " + countCorrect);
        System.out.println("Average guesses taken: " + guessAvg);
    }
}
