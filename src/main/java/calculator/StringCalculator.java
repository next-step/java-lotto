package calculator;

public class StringCalculator {
    private static final String EMPTY_STRING = "";

    public int calculate(final String input) {
        if (isNullOrEmpty(input)) {
            return Number.ZERO;
        }
        String[] splitInput = Delimiter.split(input);
        return add(splitInput).getValue();
    }

    private boolean isNullOrEmpty(String input) {
        return input == null || EMPTY_STRING.equals(input.trim());
    }

    private Number add(final String[] splitInput) {
        Number sum = Number.valueOf("0");
        for (String letter : splitInput) {
            sum = sum.add(Number.valueOf(letter));
        }
        return sum;
    }
}
