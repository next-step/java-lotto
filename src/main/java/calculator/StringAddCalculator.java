package calculator;

import java.util.Arrays;

public class StringAddCalculator {
    private static final String SEPARATOR_REGEX = ",";

    public static int calculate(String expression) {
        if (isNullOrEmpty(expression)) {
            return 0;
        }
        return sum(expression.split(SEPARATOR_REGEX));
    }

    private static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

    private static int sum(String[] intStrings) {
        return Arrays.stream(intStrings)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
