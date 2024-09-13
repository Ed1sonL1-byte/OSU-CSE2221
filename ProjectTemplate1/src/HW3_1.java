import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * A simple program that reads an integer from the user and prints all the
 * squares less than the given integer.
 */

public class HW3_1 {
    public static void main(String[] args) {
        SimpleReader input = new SimpleReader1L();
        SimpleWriter output = new SimpleWriter1L();
        output.println("Input the n:");
        int n = input.nextInteger();
        int i = 0;
        //test 1
        output.println("Test 1");
        while (i * i < n) {
            output.print(i * i + "  ");
            i++;
        }
        output.println();
        output.println("Test 2");

        //test 2
        output.println("Positive numbers divisible by 10 and less than " + n + ":");
        i = 10;
        while (i < n) {
            output.print(i + "  ");
            i += 10;
        }
        //test 3
        output.println();

        output.println("Test 3");
        output.println("Powers of two less than " + n + ":");
        i = 1;
        while (i < n) {
            output.print(i + "  ");
            i *= 2;
        }
        output.println();

        input.close();
        output.close();
    }

}
