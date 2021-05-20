package calculator;

import java.util.Objects;

public class Calculator {
    private static final String NUMBER_REGEX = "(-)?[0-9]+";

    public static int sum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }
        if (isNumber(text)) {
            return parseNumber(text);
        }
        return 1;
    }

    private static boolean isNullOrEmpty(String text) {
        return Objects.isNull(text) || text.isEmpty();
    }

    private static boolean isNumber(String text) {
        return text.matches(NUMBER_REGEX);
    }

    private static int parseNumber(String text) {
        int value = Integer.parseInt(text);
        return value;
    }

}

