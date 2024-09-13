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

public final class ABCDGuesser1 {

    /**
     * Private constructor to prevent instantiation.
     */

    private ABCDGuesser1() {

    }

    /**
     * Repeatedly asks the user for a positive real number until the user enters
     * one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number entered by the user
     */
    private static double getPositiveDouble(SimpleReader in, SimpleWriter out) {

        String input = "a";
        double number = -1;
        while (number <= 0) {
            input = in.nextLine();
            if (!FormatChecker.canParseDouble(input)) {
                out.println("Please enter a positive real number.");
            } else {
                number = Double.parseDouble(input);
            }
        }

        return number;

    }

    /**
     * Repeatedly asks the user for a positive real number not equal to 1.0
     * until the user enters one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number not equal to 1.0 entered by the user
     */
    private static double getPositiveDoubleNotOne(SimpleReader in, SimpleWriter out) {

        String input = "a";
        double number = -1;

        while (number <= 0 && number != 1.0) {
            input = in.nextLine();
            if (!FormatChecker.canParseDouble(input)) {
                out.println("Please enter a positive and not equal to 1.0 real number.");
            } else {
                number = Double.parseDouble(input);
            }

            if (number == 1.0 | number <= 0) {
                out.println("Please enter a positive and not equal to 1.0 real number.");
                number = -1;
            }
        }

        return number;

    }

    /**
     *
     * Test the method.
     *
     * @param args
     *            command-line arguments (not used)
     *
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        final double[] exponents = { -5, -4, -3, -2, -1, -0.5, -1.0 / 3.0, -0.25, 0, 0.25,
                1.0 / 3.0, 0.5, 1, 2, 3, 4, 5 };

        double u = 0, w = 0, x = 0, y = 0, z = 0;

        out.println("Please Enter values for the following variables:");
        out.println("μ: ");
        u = getPositiveDouble(in, out);
        out.println("w: ");
        w = getPositiveDoubleNotOne(in, out);
        out.println("x: ");
        x = getPositiveDoubleNotOne(in, out);
        out.println("y: ");
        y = getPositiveDoubleNotOne(in, out);
        out.println("z: ");
        z = getPositiveDoubleNotOne(in, out);

        out.println("The number you enter are μ = " + u + " w = " + w + " x = " + x
                + " y = " + y + " z = " + z);

        double bestApproximation = 0;
        double lError = 0;
        double exA = 0;
        double exB = 0;
        double exC = 0;
        double exD = 0;
        int a = 0;
        final int h = 100;
        final int t = 1000;

        while (a < exponents.length) {
            int b = 0;
            while (b < exponents.length) {
                int c = 0;
                while (c < exponents.length) {
                    int d = 0;
                    while (d < exponents.length) {

                        double approximation = Math.pow(w, exponents[a])
                                * Math.pow(x, exponents[b]) * Math.pow(y, exponents[c])
                                * Math.pow(z, exponents[d]);

                        double error = Math.abs((approximation - u) / u);

                        if (a == 0 && b == 0 && c == 0 && d == 0) {
                            lError = error;
                        }
                        if (error < lError) {
                            bestApproximation = approximation;
                            lError = error;
                            exA = exponents[a];
                            exB = exponents[b];
                            exC = exponents[c];
                            exD = exponents[d];
                        }
                        d++;
                    }
                    c++;
                }
                b++;
            }
            a++;
        }

        out.println(
                "The minimizes the error of the approximation is " + bestApproximation);
        out.println("Exponents of a is " + exA);
        out.println("Exponents of b is " + exB);
        out.println("Exponents of c is " + exC);
        out.println("Exponents of d is " + exD);
        out.println("Relative error: " + (lError * h) + "%");

        in.close();
        out.close();
    }
}
