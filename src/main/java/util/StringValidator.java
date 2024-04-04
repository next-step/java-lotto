package util;

public class StringValidator {

    private static final String NUMBER_PATTERN = "-?\\d+(\\.\\d+)?";
    private static final String OPERATOR_PATTERN = "[+\\-*/]";

    public void validateCalculated(String input) {
        if (input == null || input.isBlank())
            throw new IllegalArgumentException();
    }

    public static boolean isNumber(String str) {
        return str.matches(NUMBER_PATTERN);
    }

    public static boolean isOperator(String str) {
        return str.matches(OPERATOR_PATTERN);
    }
}
