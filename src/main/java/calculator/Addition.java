package calculator;

public class Addition {

        public static final String ADDITION = "+";

        static boolean isAddition(String operator) {
                return operator.equals(ADDITION);
        }

        static int add(int valueX, int valueY) {
                return valueX + valueY;
        }
}
