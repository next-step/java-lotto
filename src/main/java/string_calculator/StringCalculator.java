package string_calculator;

public class StringCalculator {
    private static final String ILLEGAL_ARGUMENT_ERROR_MESSAGE = "입력 값이 알맞지 않습니다.";
    private static final String DEFAULT_DELIMITER = " ";

    public static int splitAndCalculate(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_ERROR_MESSAGE);
        }
        String[] tokens = split(input);
        return calculateWithTokens(tokens);
    }

    private static boolean isBlank(String input) {
        if (input == null) {
            return true;
        }

        return input.isBlank();
    }

    private static String[] split(String input) {
        String[] tokens = input.split(DEFAULT_DELIMITER);

        if (tokens.length % 2 == 0) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_ERROR_MESSAGE);
        }

        return tokens;
    }

    private static int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_ERROR_MESSAGE);
        }
    }

    private static int calculateWithTokens(String[] tokens) {
        int result = toInt(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            Operator operator = Operator.from(tokens[i]);
            int num = toInt(tokens[i + 1]);
            result = operator.operate(result, num);
        }
        return result;
    }
}
