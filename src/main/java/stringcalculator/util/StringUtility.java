package stringcalculator.util;

public class StringUtility {
    private final static String EXCEPTION_MESSAGE_BLANK_INPUT = "입력값이 빈 값이거나 공백으로만 이뤄졌습니다.";
    private final static String EXCEPTION_MESSAGE_ILLEGAL_OPERATION = "입력된 기호가 올바르지 않습니다.";
    private final static String SEPARATOR = " ";
    private final static String LEGAL_OPERATOR = "+-*/";

    public static void validateBlankString(String input) {
        if (blankString(input)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_BLANK_INPUT);
        }
    }

    private static boolean blankString(String input) {
        return input.isBlank();
    }

    public static String[] split(String str) {
        return str.split(SEPARATOR);
    }

    public static void validateOperator(String[] values) {
        for (int i = 1; i < values.length; i += 2) {
            illegalOperator(values[i]);
        }
    }

    private static void illegalOperator(String operator) {
        if (!LEGAL_OPERATOR.contains(operator)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_ILLEGAL_OPERATION);
        }
    }

    public static int convertToInt(String value) {
        return Integer.parseInt(value);
    }
}
