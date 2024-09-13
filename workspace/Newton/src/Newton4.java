import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Utility class to calculate square roots using Newton's method.
 *
 * @author Put your name here Edison Li
 *
 */

public final class Newton4 {

    /**
     * Private constructor to prevent instantiation.
     */
    private Newton4() {
        // Prevent instantiation
    }

    /**
     * Computes the estimate of square root of x to within a relative error.
     *
     * @param x
     *            the non-negative number to compute the square root of
     * @param error
     *            the relative error threshold for the calculation
     * @return estimate of square root, or 0 if x is 0
     */

    private static double sqrt(double x, double error) {
        // Special case: if x is 0, return 0 immediately
        if (x == 0) {
            return 0;
        }
        // Initial guess for the square root
        double r = x;

        while (Math.abs(r * r - x) / x >= error * error) {
            r = (r + x / r) / 2;
        }

        return r;
    }

    /**
     * Main method that drives the program. It prompts the user to input a
     * number and computes the square root of the number based on the provided
     * error margin. The program continues until the user enters a negative
     * number.
     *
     * @param args
     *            command-line arguments (not used)
     */

    public static void main(String[] args) {
        SimpleWriter output = new SimpleWriter1L();
        SimpleReader input = new SimpleReader1L();
        boolean signW = true;
        double result = 0;
        double error = 0;
        double number = 0;
        output.println("Please give the value of ε:");
        error = input.nextDouble();

        while (signW) {
            output.print("Please enter a positive number: ");
            number = input.nextDouble();

            if (number < 0) {
                signW = false;
                output.println("Plsss input a positive number. Program Exit.");
            } else if (number >= 0) {
                result = sqrt(number, error);
                output.println("The square root is: " + result);
            }
        }
        input.close();
        output.close();

    }

}
