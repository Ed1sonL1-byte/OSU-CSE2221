import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * This class contains methods to perform input validation for a positive
 * integer.
 *
 * @author Put your name here Edison Li
 *
 */

public final class HW5Assign1 {

    /**
     * Private constructor to prevent instantiation.
     */

    private HW5Assign1() {

    }

    /**
     * Repeatedly asks the user for a positive integer until the user enters
     * one. Returns the positive integer.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive integer entered by the user
     */
    private static int getPositiveInteger(SimpleReader in, SimpleWriter out) {
        int result = -1; // Initialize to a value that is not positive
        boolean flag = false;

        while (!flag) {
            out.print("Please enter a positive integer: ");
            String input = in.nextLine();

            if (FormatChecker.canParseInt(input)) {
                result = Integer.parseInt(input); // Convert to integer
                if (result > 0) { // Check if it is a positive integer
                    flag = true;
                } else {
                    out.println("The number must be positive.");
                }
            } else {
                out.println("That's not a valid integer.");
            }
        }
        return result;
    }

    /**
     * The main method to test the getPositiveInteger function. It prompts the
     * user for input and outputs the valid positive integer entered.
     *
     * @param args
     *            command line arguments (not used)
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        int positiveInteger = getPositiveInteger(in, out);
        out.println("You entered the positive integer: " + positiveInteger);

        in.close();
        out.close();
    }
}
