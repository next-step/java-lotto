package calculator.utils;

public class StringUtils {
    private static final String NUMBER_EXPRESSION = "^(0|-?[1-9][0-9]*)$";

    private StringUtils() {}

    public static boolean isBlank(final String value) {
        return value == null || value.trim().isEmpty();
    }

    public static boolean isNumber(final String value) {
        return value.matches(NUMBER_EXPRESSION);
    }
}
