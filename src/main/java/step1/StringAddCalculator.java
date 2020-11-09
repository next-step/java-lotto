package step1;

public class StringAddCalculator {
    public static int splitAndSum(final String text) {
        final Expression expression = Expression.of(text);

        if (expression.isNotNeedCalculate()) {
            return expression.toNumber();
        }

        return -1;
    }
}
