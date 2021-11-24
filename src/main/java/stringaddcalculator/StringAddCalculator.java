package stringaddcalculator;

public final class StringAddCalculator {

    private static final Number ZERO = Number.init();

    private StringAddCalculator() {
    }

    public static int splitAndSum(String input) {
        Expression expression = new Expression(input);
        if (expression.isNullOrEmpty()) {
            return 0;
        }

        Numbers numbers = expression.numbers();
        return numbers.sum();
    }
}
