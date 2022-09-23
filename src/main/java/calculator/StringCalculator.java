package calculator;

import java.util.Queue;

public class StringCalculator {
    public static final String DEFAULT_OPERATOR = "+";
    public static final String DEFAULT_DELIMITER = " ";

    private final Tokenizer tokenizer = new Tokenizer(DEFAULT_DELIMITER);

    public int calculate(String input) {
        Queue<String> tokens = tokenizer.queue(input);
        return calculate(tokens, DEFAULT_OPERATOR, 0);
    }

    private int calculate(Queue<String> tokens, String operator, int result) {
        if (tokens.isEmpty()) {
            return result;
        }

        String token = tokens.remove();

        try {
            int number = Integer.parseInt(token);
            result = operate(operator, result, number);
            return calculate(tokens, operator, result);
        } catch (NumberFormatException e) {
            return calculate(tokens, token, result);
        }
    }

    private int operate(String operatorType, int num1, int num2) {
        Operator operator = OperatorFactory.findOperator(operatorType);
        return operator.operate(num1, num2);
    }
}
