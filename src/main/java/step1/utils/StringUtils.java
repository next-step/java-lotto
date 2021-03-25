package step1.utils;

import step1.constants.Constants;

public class StringUtils {

    public static boolean isBlank(final String input) {
        if (input == null || input.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public static String[] split(final String input, String pattern) {
        return input.split(pattern);
    }

    public static boolean isNumber(final String input) {
        return input.matches(Constants.NUMBER_EXPRESSION);
    }
}
