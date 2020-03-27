package calculator;

public class StringCalculator {
    private static final String EMPTY_STRING = "";

    public int calculate(final String input) {
        if (isNullOrEmpty(input)) {
            return Number.ZERO;
        }
        Numbers numbers = Numbers.valueOf(Delimiter.split(input));
        return numbers.sum();
    }

    private boolean isNullOrEmpty(String input) {
        return input == null || EMPTY_STRING.equals(input.trim());
    }
}
