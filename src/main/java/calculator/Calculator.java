package calculator;


import java.util.regex.Pattern;

public class Calculator {

    public static final int DEFAULT_RESULT = 0;

    private static final String EMPTY_STRING = "";
    private static final Pattern DELIMITER_PATTERN = Pattern.compile("[,:]");

    private Calculator() {
    }

    public static int calculate(String expression) {
        if (isEmpty(expression)) {
            return DEFAULT_RESULT;
        }
        Numbers numbers = Numbers.from(expression, DELIMITER_PATTERN);
        return numbers.sum();
    }

    private static boolean isEmpty(String inputNum) {
        return inputNum == null || inputNum.equals(EMPTY_STRING);
    }
}
