package calculator;

import calculator.type.OperatorType;

import java.util.StringTokenizer;

public class StringCalculator {
    private static final String INVALID_INPUT_MESSAGE = "수식이 올바르지 않습니다.";
    private static final String DEFAULT_OPERATOR_TYPE = OperatorType.ADD.getOperator();
    private static final int DEFAULT_VALUE = 0;

    private StringTokenizer tokenizer;

    public int calculate(String input) {
        setTokenizer(input);
        return operate(DEFAULT_OPERATOR_TYPE, DEFAULT_VALUE);
    }

    private void setTokenizer(String input) {
        try {
            tokenizer = new StringTokenizer(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    private int operate(String operator, int result) {
        if (hasNoMoreTokens()) {
            return result;
        }

        String token = tokenizer.nextToken();
        OperatorType supportedOperator = OperatorType.findOperator(operator);

        if (isNumber(token)) {
            result = supportedOperator.operate(result, Integer.parseInt(token));
            return operate(operator, result);
        }

        return operate(token, result);
    }

    private boolean isNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean hasNoMoreTokens() {
        return !tokenizer.hasMoreTokens();
    }
}
