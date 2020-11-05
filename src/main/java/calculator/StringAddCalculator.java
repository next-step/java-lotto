package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    private StringAddCalculator() {
    }

    public static int splitAndSum(String expression) {
        if (isNullOrEmpty(expression)) {
            return 0;
        }
        return Arrays.stream(expression.split(",|:"))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static boolean isNullOrEmpty(String expression) {
        return expression == null || expression.isEmpty();
    }
}
