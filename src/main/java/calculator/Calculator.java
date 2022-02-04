package calculator;

import java.util.Arrays;

public class Calculator {

    private static final int UNAVAILABLE_THRESHOLD = 0;
    private static final int EMPTY_NUMBER = 0;
    private static final String EXCEPTION_MESSAGE_WHEN_NEGATIVE_EXISTS = "음수가 포함될 수 없습니다.";

    private Calculator() {}

    public static int calculate(final String expression) {
        if (expression == null || expression.isEmpty()) {
            return EMPTY_NUMBER;
        }

        String[] operands = Tokenizer.splitExpression(expression);
        validateExpression(operands);

        return getSum(operands);
    }

    private static int getSum(final String[] operands) {
        return Arrays.stream(operands)
            .mapToInt(Integer::parseInt)
            .sum();
    }

    private static void validateExpression(final String[] operands) {
        if (negativeExists(operands)) {
            throw new RuntimeException(EXCEPTION_MESSAGE_WHEN_NEGATIVE_EXISTS);
        }
    }

    private static boolean negativeExists(final String[] operands) {
        return Arrays.stream(operands)
            .mapToInt(Integer::parseInt)
            .anyMatch(number -> number < UNAVAILABLE_THRESHOLD);
    }
}
