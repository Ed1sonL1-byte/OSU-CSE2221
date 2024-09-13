
/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here Edison Li
 *
 */
public final class Newton2 {

    /**
     * Defines the relative error.
     */

    private static final double RELATIVE_ERROR = 0.0001;

    /**
     * Computes estimate of square root of x to within relative error 0.01%. If
     * x is 0, the square root is defined as 0 and the method returns 0
     * immediately.
     *
     * @param x
     *            non-negative number to compute square root of
     * @return estimate of square root, or 0 if x is 0
     */
    private static double sqrt(double x) {
        // Special case: if x is 0, return 0 immediately
        if (x == 0) {
            return 0;
        }
        // Initial guess for the square root
        double r = x;

        // Iterative computation using Newton's method
        while (Math.abs(r * r - x) / x >= RELATIVE_ERROR * RELATIVE_ERROR) {
            // Update the guess using Newton's iteration
            r = (r + x / r) / 2;
        }

        return r;
    }

}
