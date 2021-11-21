package stringaddcalculator;

public final class StringAddCalculator {

    private static final Number ZERO = Number.init();

    private StringAddCalculator() {
    }

    public static Number splitAndSum(String input) {
        Expression expression = new Expression(input);
        if (expression.isNullOrEmpty()) {
            return ZERO;
        }

        Numbers numbers = expression.numbers();
        return new Number(numbers.sum());
    }
}
