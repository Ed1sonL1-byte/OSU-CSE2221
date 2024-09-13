import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here Edison Li
 *
 */

public final class Newton3 {

    /**
     * Prevent instantiation.
     */

    private Newton3() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%. If
     * x is 0, the square root is defined as 0 and the method returns 0
     * immediately.
     *
     * @param x
     *            error non-negative number to compute square root of
     * @param error
     *            relative error threshold for the calculation
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
     * error margin. It continues until the user chooses to terminate.
     *
     * @param args
     *            command-line arguments (not used)
     */

    public static void main(String[] args) {

        SimpleWriter output = new SimpleWriter1L();
        SimpleReader input = new SimpleReader1L();

        double error = 0;
        output.println("Please give the value of ε:");
        error = input.nextDouble();
        String yInput;

        do {
            output.println("Do you want to calculate the square of x ? ");
            yInput = input.nextLine();
            if (yInput.equals("y")) {
                output.print("Please enter a positive number: ");
                double number = input.nextDouble();

                double result = sqrt(number, error);
                output.println("The square root is: " + result);
            } else {
                output.println("Program terminated.");
            }

        } while (yInput.equals("y"));

        input.close();
        output.close();

    }

}
