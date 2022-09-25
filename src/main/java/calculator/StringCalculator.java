package calculator;

import calculator.type.Operator;

import java.util.Queue;

import static calculator.type.Operator.ADD;

public class StringCalculator {
    private static final String DEFAULT_OPERATOR_TYPE = ADD;
    private static final String DEFAULT_DELIMITER = " ";

    private final Tokenizer tokenizer = new Tokenizer(DEFAULT_DELIMITER);

    public int calculate(String input) {
        Queue<String> tokens = tokenizer.queue(input);

        return operate(tokens, DEFAULT_OPERATOR_TYPE, 0);
    }

    private int operate(Queue<String> tokens, String operator, int result) {
        if (tokens.isEmpty()) {
            return result;
        }

        String token = tokens.remove();
        Operator supportedOperator = Operator.findOperator(operator);

        try {
            result = supportedOperator.operate(result, Integer.parseInt(token));
            return operate(tokens, operator, result);
        } catch (NumberFormatException e) {
            return operate(tokens, token, result);
        }
    }
}
