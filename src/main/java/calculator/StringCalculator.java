package calculator;

public class StringCalculator {
    private static final int ZERO = 0;
    private static final String DEFAULT_TOKEN_DELIMITER = ",|:";
    private static final String EMPTY_STRING = "";

    public int calculate(final String input) {
        if (input == null || EMPTY_STRING.equals(input)) {
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
        try {
            for (String letter : splitInput) {
                int parseNumber = Integer.parseInt(letter);
                if (parseNumber < 0) {
                    throw new RuntimeException("음수 입니다.");
                }
                sum += Integer.parseInt(letter);
            }
        } catch (Exception e) {
            throw e;
        }
        return sum;
    }
}
