package stringaddcalculator;

import java.util.List;

public final class StringAddCalculator {

    private static final Number ZERO = Number.init();

    private StringAddCalculator() {
    }

    public static Number splitAndSum(String input) {
        Expression expression = new Expression(input);
        if (expression.isNullOrEmpty()) {
            return ZERO;
        }

        List<Number> numbers = expression.numbers();
        return new Number(sum(numbers));
    }

    private static int sum(List<Number> numbers) {
        return numbers.stream()
                      .mapToInt(Number::getValue)
                      .sum();
    }
}
