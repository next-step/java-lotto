package calculator;


public class Calculator {

    public static final int DEFAULT_RESULT = 0;

    private static final String EMPTY_STRING = "";

    private Calculator() {
    }

    public static int calculate(String expression) {
        if (isEmpty(expression)) {
            return DEFAULT_RESULT;
        }
        return -1;
    }

    private static boolean isEmpty(String inputNum) {
        return inputNum == null || inputNum.equals(EMPTY_STRING);
    }
}
