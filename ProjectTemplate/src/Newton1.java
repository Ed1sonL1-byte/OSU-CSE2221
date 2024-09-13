/**
 * Defines the relative error.
 *
 * @author Put your name here Edison Li
 *
 */
public final class Newton1 {

    /**
     * Defines the relative error.
     */

    private static final double RELATIVE_ERROR = 0.0001;

    /**
     * Computes estimate of square root of x to within a defined relative error.
     *
     * @param x
     *            positive number to compute square root of
     * @return estimate of square root
     */
    private static double sqrt(double x) {

        double r = x;
        while (Math.abs(r * r - x) / x >= RELATIVE_ERROR * RELATIVE_ERROR) {
            r = (r + x / r) / 2;
        }
        return r;
    }

}
