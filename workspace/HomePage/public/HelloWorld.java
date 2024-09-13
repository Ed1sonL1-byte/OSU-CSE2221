import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple HelloWorld program (clear of Checkstyle and SpotBugs warnings).
 *
 * @author P. Bucci
 */
public class HelloWorld {

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */

    public static void main(String[] args) {

//        int age = this.getAge();
        SimpleWriter out = new SimpleWriter1L();
//
        out.println("Age:" + My_Method.getAge());
        out.println("Hello World!");
        out.close();
    }

    public class My_Method {
        private static int age = 4;
        static String name;

        public void setAge(int age) {
            this.age = age;
        }

        public static int getAge() {
            return age;
        }

        /**
         * No argument constructor--private to prevent instantiation.
         */

    }
}
