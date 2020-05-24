package stringcalculator.domain;

public class StringAddCalculator {
    private static final int INITIAL_RESULT_VALUE = 0;

    private StringAddCalculator() {
    }

    public static long execute(final String expression) {
        if (isNullOrEmpty(expression)) {
            return INITIAL_RESULT_VALUE;
        }

        return StringExpressionConverter.convert(expression)
                .stream()
                .map(Operand::new)
                .reduce(new Operand(INITIAL_RESULT_VALUE), Operand::add)
                .getValue();
    }

    private static boolean isNullOrEmpty(String expression) {
        return expression == null || expression.isEmpty();
    }
}
