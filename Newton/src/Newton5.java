import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Utility class for calculating k-th roots using Newton's method.
 *
 * @author Put your name here Edison Li
 *
 */

public final class Newton5 {

    /**
     * Private constructor to prevent instantiation.
     */
    private Newton5() {
        // Prevent instantiation
    }

    /**
     * Computes the k-th root of a given number x to within a relative error.
     *
     * @param x
     *            the non-negative number to compute the k-th root of
     * @param k
     *            the degree of the root
     * @param error
     *            the relative error threshold for the calculation
     * @return the k-th root of x, or 0 if x is 0
     */

    private static double kthRoot(double x, int k, double error) {
        if (x == 0) {
            return 0;
        }

        double r = x;
        while (Math.abs(Math.pow(r, k) - x) / x >= error * error) {
            r = ((k - 1) * r + x / Math.pow(r, k - 1)) / k;
        }

        return r;
    }

    /**
     * Main method that drives the program. It prompts the user to input a
     * number and a root degree, then calculates the k-th root of the number
     * based on the provided error margin.
     *
     * @param args
     *            command-line arguments (not used)
     */

    public static void main(String[] args) {

        SimpleReader input = new SimpleReader1L();
        SimpleWriter output = new SimpleWriter1L();
        output.print("Please give the value of ε: ");
        double error = input.nextDouble();

        while (true) {
            output.print("Please enter a positive number: ");
            double number = input.nextDouble();
            if (number < 0) {
                output.println("Plsss enter a positive number.");
                break;
            }

            output.print("Please enter the root k: ");
            int k = input.nextInteger();

            double result = kthRoot(number, k, error);
            output.println("The " + k + "-th root of " + number + " is approximately: "
                    + result);
        }

        output.close();
        input.close();
    }
}
