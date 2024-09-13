import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class HW3_4 {

    public static void main(String[] args) {
        SimpleReader input = new SimpleReader1L();
        SimpleWriter output = new SimpleWriter1L();
        int n, i = 0;
        double pi = 0.0;
        output.println("Please input the value of n");
        n = input.nextInteger();
        while (i <= n) {
            pi = pi + (Math.pow(-1, i)) / (2 * i + 1);
            i++;
        }
        pi = pi * 4;
        output.print(pi);

        input.close();
        output.close();

    }
}
