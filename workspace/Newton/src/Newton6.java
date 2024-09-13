import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * Utility class for computing k-th roots of numbers using Newton's method.
 *
 * @author Put your name here Edison Li
 *
 */

public final class Newton6 {

    /**
     * Private constructor to prevent instantiation.
     */
    private Newton6() {
        // Prevent instantiation
    }

    /**
     * Computes the k-th root of a given number x to within a relative error.
     *
     * @param x
     *            the non-negative number to compute the k-th root of
     * @param k
     *            the degree of the root
     * @param epsilon
     *            the relative error threshold for the calculation
     * @return the k-th root of x, or 0 if x is 0
     */

    private static double kthRoot(double x, int k, double epsilon) {
        if (x == 0) {
            return 0;
        }

        double r = x;
        while (Math.abs(Math.pow(r, k) - x) / x >= epsilon * epsilon) {
            r = ((k - 1) * r + x / Math.pow(r, k - 1)) / k;
        }

        return r;
    }

    /**
     * Main method that drives the program. It prompts the user to input a
     * number, k-th root, and error threshold, then calculates the k-th root of
     * the number.
     *
     * @param args
     *            command-line arguments (not used)
     */

    public static void main(String[] args) {
        SimpleWriter output = new SimpleWriter1L();
        SimpleReader input = new SimpleReader1L();

        double error = 0, number = 0;
        while (true) {
            output.println("Enter the relative error ε: ");
            String errorInput = input.nextLine();
            //check it
            while (!FormatChecker.canParseDouble(errorInput)) {
                output.println("The enter is not a number, pls re-enter it:");
                errorInput = input.nextLine(); //reset the errorInput
            }

            error = Double.parseDouble(errorInput);
            if (error > 0) {
                break;
            } else {
                output.println("Error: ε must be a positive number. Pls re-enter it. ");
            }
        }

        while (true) {
            output.println("Please enter a positive number to compute its "
                    + "k-th root (negative to quit): ");
            String numberInput = input.nextLine();
            //check it
            while (!FormatChecker.canParseDouble(numberInput)) {
                output.println("The enter is not a number, pls re-enter it:");
                numberInput = input.nextLine(); //reset the numberInput
            }

            number = Double.parseDouble(numberInput);
            if (number < 0) {
                output.println(
                        "Error: Number must be a positive number. Pls re-enter it.");
            } else {
                break;
            }

        }

        int k = 0;
        while (true) {
            output.println("Please enter the root k: ");
            String kInput = input.nextLine();
            k = Integer.parseInt(kInput);
            //check it is number
            while (!FormatChecker.canParseInt(kInput)) {
                output.println("The enter is not a number, pls re-enter it:");
                kInput = input.nextLine();
            }

            if (k >= 2) {
                break;
            } else {
                output.println("Error: k must be an integer greater "
                        + "than or equal to 2. Pls re-enter it.");
            }
        }

        double result = kthRoot(number, k, error);
        output.println(
                "The " + k + "-th root of " + number + " is approximately: " + result);
        output.close();
        input.close();
    }
}
