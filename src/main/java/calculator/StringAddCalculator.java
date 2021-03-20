package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    public static int splitAndSum(Expression expression) {
        if (expression.isEmptyOrNull()) {
            return 0;
        }

        expression.checkNegative();
        Splitted splitted = new Splitted(expression);
        return sum(splitted.expression());
    }

    private static int sum(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
