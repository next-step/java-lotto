package calculator;

public class Division {

        public static final String DIVISION = "/";

        static boolean isDivision(String operator) {
                return operator.equals(DIVISION);
        }

        static int divide(int valueX, int valueY) {
                return valueX / valueY;
        }
}
