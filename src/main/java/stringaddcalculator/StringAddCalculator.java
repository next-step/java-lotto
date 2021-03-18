package stringaddcalculator;

import stringaddcalculator.domain.Numbers;

public class StringAddCalculator {
    public static final int ZERO = 0;

    private static Numbers numbers;

    private StringAddCalculator() {}

    public static int splitAndSum(String expression) {
        if (isEmptyExpression(expression)) {
            return ZERO;
        }
        numbers = Numbers.of(expression);
        return numbers.sum();
    }

    private static boolean isEmptyExpression(String expression) {
        return expression == null || expression.trim().isEmpty();
    }
}
