package step1;

import java.util.List;

public class StringAddCalculator {
    public static int splitAndSum(final String text) {
        final Expression expression = Expression.of(text);

        if (expression.isNotNeedCalculate()) {
            return expression.toNumber();
        }

        final List<String> numbers = expression.toTokens();

        return sum(numbers);
    }

    private static int sum(final List<String> numbers) {
        return numbers.stream()
                .map(Integer::parseInt)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
