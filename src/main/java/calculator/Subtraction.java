package calculator;

public class Subtraction {

        public static final String SUBTRACTION = "-";

        static boolean isSubtraction(String operator) {
                return operator.equals(SUBTRACTION);
        }

        static int subtract(int valueX, int valueY) {
                return valueX - valueY;
        }
}
