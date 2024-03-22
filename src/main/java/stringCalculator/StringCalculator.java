package stringCalculator;

import java.util.List;

public class StringCalculator {
    private static final int OPERATOR_INDEX_TERM = 2;
    private static final String BLANK = " ";
    private static final String BLANK_INPUT_MESSAGE = "input value is blank";
    private static final String INVALID_OPERATOR_MESSAGE = "input value is invalid operation symbol";

    public static int calculation(String input) {
        checkBlank(input);

        List<String> tokens = List.of(input.split(BLANK));

        return calculate(tokens);
    }

    private static int calculate(List<String> tokens) {
        int result = Integer.parseInt(tokens.get(0));

        for (int i = 1; i < tokens.size(); i += OPERATOR_INDEX_TERM) {
            String operator = tokens.get(i);
            int operand = toInt(tokens.get(i + 1));
            result = Operator.findOperator(operator).apply(result, operand);
        }
        return result;
    }

    private static void checkBlank(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(BLANK_INPUT_MESSAGE);
        }
    }

    private static int toInt(String token) {
        return Integer.parseInt(token);
    }
}
