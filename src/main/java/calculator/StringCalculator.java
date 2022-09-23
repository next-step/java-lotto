package calculator;

import java.util.Queue;

import static calculator.Operator.ADD;

public class StringCalculator {
    private static final String DEFAULT_OPERATOR_TYPE = ADD;
    private static final String DEFAULT_DELIMITER = " ";

    private final Tokenizer tokenizer = new Tokenizer(DEFAULT_DELIMITER);

    public int calculate(String input) {
        Queue<String> tokens = tokenizer.queue(input);

        return calculate(tokens, DEFAULT_OPERATOR_TYPE, 0);
    }

    private int calculate(Queue<String> tokens, String operator, int result) {
        if (tokens.isEmpty()) {
            return result;
        }

        String token = tokens.remove();
        if (isNumber(token)) {
            result = Operator.mapping(operator)
                            .operate(result, Integer.parseInt(token));

            return calculate(tokens, operator, result);
        }

        return calculate(tokens, token, result);
    }

    private boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
