import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class HW5Assign6 {

    public static boolean allTheSame(int x, int y, int z) {
        return x == y && y == z && x == z;
    }

    public static boolean allDifferent(int x, int y, int z) {
        return x != y && x != z && y != z;
    }

    public static boolean sorted(int x, int y, int z) {
        return x <= y && y <= z;
    }

    public static void main(String arg[]) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        int x = 0, y = 0, z = 0;
        out.println("Please enter the number of x");

        x = in.nextInteger();

        out.println("Please enter the number of y");
        y = in.nextInteger();

        out.println("Please enter the number of z");
        z = in.nextInteger();

        out.println("allTheSame: " + allTheSame(x, y, z));
        out.println("allDifferent: " + allDifferent(x, y, z));
        out.println("sorted: " + sorted(x, y, z));

        in.close();
        out.close();

    }

}
