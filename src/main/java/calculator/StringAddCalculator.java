package calculator;

import java.util.Arrays;

public class StringAddCalculator {
    public static int calculate(String expression) {
        if (isNullOrEmpty(expression)) {
            return 0;
        }
        try {
            return Integer.parseInt(expression);
        } catch (NumberFormatException e) {
            String[] a = expression.split(",");
            return Arrays.stream(a).map(Integer::parseInt).reduce(Integer::sum).get();
        }

    }

    private static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }
}
