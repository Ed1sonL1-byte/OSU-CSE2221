package HW4;

import components.random.Random;
import components.random.Random1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Monte Carlo Estimate: compute percentage of pseudo-random points in [0.0,1.0)
 * interval that fall in the left half subinterval [0.0,0.5).
 */
public final class HW4_a {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private HW4_a() {
    }

    private static boolean pointIsInCircle(double xCoord, double yCoord) {
        double distance = Math.pow(xCoord - 1, 2) + Math.pow(yCoord - 1, 2);
        if (distance < 1) {
            return true;
        } else {
            return false;
        }

    }

    private static int numberOfPointsInCircle(int n) {
        Random randomX = new Random1L();
        Random randomY = new Random1L();
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (pointIsInCircle(randomX.nextDouble() * 2, randomY.nextDouble() * 2)) {
                total++;
            }
        }
        return total;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        /*
         * Open input and output streams
         */
        SimpleReader input = new SimpleReader1L();
        SimpleWriter output = new SimpleWriter1L();
        /*
         * Ask user for number of points to generate
         */
        output.print("Number of points: ");
        int n = input.nextInteger();

        int total = numberOfPointsInCircle(n);

        double estimate = (100.0 * total) / n;
        output.println("Estimate of percentage: " + estimate + "%");
        /*
         * Close input and output streams
         */
        input.close();
        output.close();
    }

}
