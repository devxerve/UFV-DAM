package main;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main class that manages the creation and manipulation of arrays of odd and even numbers.
 * It allows the user to input the size of an array, generate random numbers, check parity,
 * display arrays, and calculate statistics and the greatest common divisor.
 *
 * @author [DevXervE &lt;aviercerverarodriguezgmail.com&gt;]
 * @version 1.0
 * @param INI_INT Constant made in order to initialize all integer variables in the code
 * @param DIVIDER Constant made to separate prints visually during the code
 */
public class Main {
    static final int INI_INT = 0; 
    static final String DIVIDER = "\n--------------------";

    /**
     * Reads an integer from standard input using a Scanner object.
     * If the input is not a number, it returns 0 and displays an error message.
     *
     * @param input Scanner for reading user input.
     * @return The integer read or 0 if the input is invalid.
     */
    public static int readInt(Scanner input) {
        int output = INI_INT;
        try {
            output = input.nextInt();
        } catch (InputMismatchException ex) {
            output = INI_INT;
            input.next();
            System.out.println("ERROR! only numbers are allowed here, program will end now");
        }
        return output;
    }

    /**
     * Generates a random number within a specified range.
     *
     * @param min Minimum value of the range (inclusive).
     * @param max Maximum value of the range (inclusive).
     * @return Random number generated in the range [min, max].
     */
    public static int numGen(int min, int max) {
        int output;
        output = (int) (Math.random() * (max - min + 1) + min);
        return output;
    }

    /**
     * Checks if a number is even.
     *
     * @param num Number to check.
     * @return true if the number is even, false otherwise.
     */
    public static boolean checkEven(int num) {
        return num % 2 == 0;
    }

    /**
     * Fills an array with odd numbers generated randomly.
     * Each generated number is checked to ensure it is odd before being inserted.
     *
     * @param odds Array of integers to be filled with odd numbers.
     */
    public static void fillOdds(int[] odds) {
        int temp = INI_INT;
        for (int i = 0; i < odds.length; i++) {
            do {
                temp = numGen(5, 50);
            } while (checkEven(temp));
            odds[i] = temp;
        }
    }

    /**
     * Fills an array with even numbers generated randomly.
     * Each generated number is checked to ensure it is even before being inserted.
     *
     * @param evens Array of integers to be filled with even numbers.
     */
    public static void fillEvens(int[] evens) {
        int temp = INI_INT;
        for (int i = 0; i < evens.length; i++) {
            do {
                temp = numGen(1, evens.length);
            } while (!checkEven(temp));
            evens[i] = temp;
        }
    }

    /**
     * Displays all values stored in an array.
     *
     * @param array Array of integers to display.
     */
    public static void showArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + i + "]=" + array[i] + " | ");
        }
    }

    /**
     * Finds the smallest number in an array.
     *
     * @param array Array of integers.
     * @return The smallest number in the array.
     */
    public static int smallerNumber(int[] array) {
        int output = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < output) {
                output = array[i];
            }
        }
        return output;
    }

    /**
     * Finds the largest number in an array.
     *
     * @param array Array of integers.
     * @return The largest number in the array.
     */
    public static int greaterNumber(int[] array) {
        int output = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > output) {
                output = array[i];
            }
        }
        return output;
    }

    /**
     * Calculates the greatest common divisor (GCD) of two numbers using Euclid's algorithm.
     *
     * @param a First number.
     * @param b Second number.
     * @return The GCD of a and b.
     */
    public static int gcd(int a, int b) {
        int temp = INI_INT;
        while (b != INI_INT) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * Main method that runs the program.
     * Allows the user to create arrays of odd and even numbers, display them,
     * find extreme values, and calculate the GCD of two numbers.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int odds_size, evens_size, evensSmall, evensGreat;
        odds_size = evens_size = evensSmall = evensGreat = INI_INT;

        System.out.println("Please, type the size of the Array you want to create");
        odds_size = readInt(input);

        if (odds_size > INI_INT) {
            int[] odds = new int[odds_size];
            fillOdds(odds);

            evens_size = smallerNumber(odds);
            int[] evens = new int[evens_size];
            fillEvens(evens);

            System.out.println(DIVIDER);
            System.out.println("Array containing odd numbers");
            showArray(odds);
            System.out.println(DIVIDER);
            System.out.println("Array containing even numbers");
            showArray(evens);
            System.out.println(DIVIDER);
            System.out.println("The greatest number of the Array containing odds is: " + greaterNumber(odds));
            System.out.println("The smallest number of the Array containing odds is: " + (smallerNumber(odds)));
            System.out.println(DIVIDER);
            System.out.println("The greatest number of the Array containing evens is: " + (evensGreat = greaterNumber(evens)));
            System.out.println("The smallest number of the Array containing evens is: " + (evensSmall = smallerNumber(evens)));
            System.out.println(DIVIDER);
            System.out.println("The greatest common divisor of " + smallerNumber(evens) + " and " + greaterNumber(evens) + " is:  " + gcd(evensSmall, evensGreat));
        } else if (odds_size != INI_INT) {
            System.out.println("Invalid size, program will end now");
        }

        input.close();
    }
}
