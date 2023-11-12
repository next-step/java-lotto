package calculator;

public class Multiplication {

        public static final String MULTIPLICATION = "*";

        static boolean isMultiplication(String operator) {
                return operator.equals(MULTIPLICATION);
        }

        static int multiple(int valueX, int valueY) {
                return valueX * valueY;
        }
}
