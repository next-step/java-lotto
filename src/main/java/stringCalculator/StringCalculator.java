package stringCalculator;

import java.util.List;

public class StringCalculator {
    private static final List<String> OPERATION_SYMBOL = List.of("+", "-", "*", "/");
    private static final String BLANK = " ";
    private static final String BLANK_INPUT_MESSAGE = "input value is blank";
    private static final String INVALID_OPERATOR_MESSAGE = "input value is invalid operation symbol";

    public static int calculation(String input) {
        checkBlank(input);

        List<String> tokens = List.of(input.split(BLANK));
        ckeckOperations(tokens);

        return calculate(tokens);
    }

    private static int calculate(List<String> tokens) {
        int result = Integer.parseInt(tokens.get(0));

        for (int i = 1; i < tokens.size(); i += 2) {
            String operator = tokens.get(i);
            int operand = Integer.parseInt(tokens.get(i + 1));
            result = Operation.findOperator(operator).apply(result, operand);
        }
        return result;
    }

    private static void checkBlank(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(BLANK_INPUT_MESSAGE);
        }
    }

    private static void ckeckOperations(List<String> tokens) {
        for (int i = 1; i < tokens.size(); i += 2) {
            ckeckOpertaion(tokens.get(i));
        }
    }

    private static void ckeckOpertaion(String token) {
        if (!OPERATION_SYMBOL.contains(token)) {
            throw new IllegalArgumentException(INVALID_OPERATOR_MESSAGE);
        }
    }
}
