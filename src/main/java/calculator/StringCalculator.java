package calculator;

import calculator.type.Operator;

import java.util.Queue;
import java.util.StringTokenizer;

import static calculator.type.Operator.ADD;

public class StringCalculator {
    private static final String INVALID_INPUT_MESSAGE = "수식이 올바르지 않습니다.";
    private static final String DEFAULT_OPERATOR_TYPE = ADD;
    private static final int DEFAULT_VALUE = 0;

    private StringTokenizer tokenizer;

    public int calculate(String input) {
        try {
            tokenizer = new StringTokenizer(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }

        return operate(DEFAULT_OPERATOR_TYPE, DEFAULT_VALUE);
    }

    private int operate(String operator, int result) {
        if (hasNoMoreTokens()) {
            return result;
        }

        String token = tokenizer.nextToken();
        Operator supportedOperator = Operator.findOperator(operator);

        try {
            result = supportedOperator.operate(result, Integer.parseInt(token));
            return operate(operator, result);
        } catch (NumberFormatException e) {
            return operate(token, result);
        }
    }

    private boolean hasNoMoreTokens() {
        return !tokenizer.hasMoreTokens();
    }
}
