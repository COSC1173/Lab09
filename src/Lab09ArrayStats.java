/*
 * COSC 1173 Programming Lab - Lab 09: Array Statistics
 * Textbook reference: Liang, Chapter 7 (Single-Dimensional Arrays)
 *
 * Student name: [TYPE YOUR NAME HERE]
 * Date:         [TYPE TODAY'S DATE HERE]
 *
 * DO NOT change any method name, parameter list, or return type.
 * REQUIREMENT: every executable statement you write must carry a line comment.
 */
public class Lab09ArrayStats {

    /**
     * STEP 1 - Returns the sum of every element.
     * TODO: use a for loop (or an enhanced for loop) with an accumulator.
     * Return 0 when the array is null or has length 0.
     */
    public static int sum(int[] values) {
        return 0; // placeholder
    }

    /**
     * STEP 2 - Returns the arithmetic mean of the elements.
     * TODO: reuse your own sum method rather than writing the loop twice.
     * Divide by values.length as a double so the result is not truncated.
     * Return 0.0 for a null or empty array.
     */
    public static double average(int[] values) {
        return 0.0; // placeholder
    }

    /**
     * STEP 3 - Returns the index of the largest element. If the largest value occurs
     * more than once, return the index of the FIRST occurrence. Return -1 for a null
     * or empty array.
     * TODO: assume index 0 holds the maximum, then scan from index 1 and update
     * only when you find something strictly greater.
     */
    public static int indexOfMax(int[] values) {
        return -1; // placeholder
    }

    /**
     * STEP 4 - Returns the index of the first element equal to key, or -1 if key
     * is absent. This is the linear search algorithm from Section 7.10.1.
     */
    public static int linearSearch(int[] values, int key) {
        return -1; // placeholder
    }

    /**
     * STEP 5 - Returns a NEW array holding the elements in reverse order.
     * The array passed in must not be modified - the caller still needs it.
     * TODO: allocate a new array of the same length, then copy element i of the
     * original into position length - 1 - i of the copy.
     * Return an empty array (new int[0]) when values is null.
     */
    public static int[] reversed(int[] values) {
        return new int[0]; // placeholder
    }

    /**
     * STEP 6 - Counts how many elements are strictly greater than threshold.
     */
    public static int countAbove(int[] values, double threshold) {
        return 0; // placeholder
    }

    /** STEP 7 - TODO: build a sample array and print the result of each method. */
    public static void main(String[] args) {
        int[] scores = {88, 92, 79, 95, 61}; // sample data for the demonstration
        System.out.println("Sum: " + sum(scores)); // example call
    }
}
