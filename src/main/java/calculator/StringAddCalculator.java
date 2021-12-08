package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    private static final String TOKEN_DELIMITER = ",|:";

    public static int splitAndSum(String expression) {
        if (expression == null || expression.isEmpty()) {
            return 0;
        }

        return sumNumbers(expression.split(TOKEN_DELIMITER));
    }

    private static int sumNumbers(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
    }

}
