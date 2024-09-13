import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public final class HW5Assign3 {

    private static void main() {

        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        /**
         * Sum sum of all even numbers between 2 and 100
         */
        int sumEven = 0;
        for (int i = 2; i <= 100; i += 2) {
            sumEven += i;
        }
        out.println("Sum of all even numbers between 2 and 100: " + sumEven);

        /**
         * The sum of all squares between 1 and 100
         */
        int sumSquare = 0;
        for (int i = 1; i <= 100; i++) {
            sumSquare += i * i;
        }
        out.println("Sum of all squares between 1 and 100: " + sumSquare);

        /**
         * All powers of 2 from 2^0 up to 2^20 (inclusive).
         */
        int powers = 0;
        for (int i = 0; i < 20; i++) {
            powers = (int) Math.pow(2, i);
        }
        /**
         * The sum of all odd numbers between a and b (inclusive), where a and b
         * are integer variables with a ≤ b
         */
        int a = in.nextInteger();
        int b = in.nextInteger();
        int sumOdd = 0;
        for (int i = a; i <= b; i++) {
            if (i % 2 != 0) {
                sumOdd += i;
            }
        }
        out.println("Sum of all odd numbers between " + a + " and " + b + ": " + sumOdd);
        /**
         * The sum of all digits at odd positions (right-to-left starting at 1
         * as the right-most digit) of a numeric input. (For example, if the
         * input is 432677, the sum would be 7 + 6 + 3 = 16.)
         */
        int num = 432677;
        int sumOddPosDigits = 0;
        int position = 1;
        while (num > 0) {
            int digit = num % 10;
            if (position % 2 != 0) {
                sumOddPosDigits += digit;
            }
            num /= 10;
            position++;
        }
        out.println("Sum of digits at odd positions (right-to-left): " + sumOddPosDigits);

        /**
         * Sum of all digits at odd positions (left-to-right starting at 1) of a
         * numeric input
         */
        int num2 = 432677;
        String numStr = Integer.toString(num2);
        int sumOddPosLeftToRight = 0;

        for (int i = 0; i < numStr.length(); i++) {
            if ((i + 1) % 2 != 0) {
                sumOddPosLeftToRight += Character.getNumericValue(numStr.charAt(i));
            }
        }
        out.println("Sum of digits at odd positions (left-to-right): "
                + sumOddPosLeftToRight);

        in.close();
        out.close();
    }

}
