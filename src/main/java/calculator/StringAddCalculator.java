package calculator;

import calculator.utils.StringSplitUtil;

import java.util.Arrays;

public class StringAddCalculator {

    public static int splitAndSum(Expression expression) {
        if (expression.isEmptyOrNull()) {
            return 0;
        }

        expression.hasNegative();
        return sum(StringSplitUtil.split(expression.toString()));
    }

    private static int sum(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
