package calculator;

public final class StringAddCalculator {
    private static final int ZERO = 0;

    private StringAddCalculator() {
    }

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) return ZERO;

        Numbers numbers = Delimiter.split(text);

        if (numbers.hasOnlyOneNumber()) {
            return numbers.firstNumber();
        }

        return numbers.sum();
    }
}
