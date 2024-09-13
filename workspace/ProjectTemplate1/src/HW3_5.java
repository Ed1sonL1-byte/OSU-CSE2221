import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class HW3_5 {

    public static void main(String[] args) {
        SimpleReader input = new SimpleReader1L();
        SimpleWriter output = new SimpleWriter1L();

        int areaBound, sum = 0;
        output.print("Please give a INTEGER value to areBound: ");
        areaBound = input.nextInteger();

        for (int n = 1; n * n < areaBound; n++) {
            for (int m = 1; m * m < areaBound; m++) {
                sum += (n * n + m * m);
            }
        }
        output.print(sum);

        input.close();
        output.close();

    }
}
