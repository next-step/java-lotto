package calculator;

public class StringCalculator {
    private static final int ZERO = 0;
    private static final String DEFAULT_TOKEN_DELIMITER = ",|:";

    public int calculate(final String input) {
        if (input == null || "".equals(input)) {
            return ZERO;
        }
        String[] splitInput = splitInput(input);
        return add(splitInput);
    }

    public String[] splitInput(final String input) {
        return input.split(DEFAULT_TOKEN_DELIMITER);
    }

    private int add(final String[] splitInput) {
        int sum = ZERO;
        for (String letter : splitInput) {
            sum += Integer.parseInt(letter);
        }
        return sum;
    }
}
