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

        return calculate(tokens);
    }

    private static int calculate(List<String> tokens) {
        int result = Integer.parseInt(tokens.get(0));

        for (int operatorIndex = 1; operatorIndex < tokens.size(); operatorIndex += 2) {
            String operator = tokens.get(operatorIndex);
            int operand = Integer.parseInt(tokens.get(operatorIndex + 1));
            result = Operation.findOperator(operator).apply(result, operand);
        }
        return result;
    }

    private static void checkBlank(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(BLANK_INPUT_MESSAGE);
        }
    }
}
