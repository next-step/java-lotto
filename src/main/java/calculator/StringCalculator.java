package calculator;

import java.util.Map;
import java.util.function.IntBinaryOperator;

public class StringCalculator {
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLE = "*";
    private static final String DIVISION = "/";
    private static final String INCORRECT_VALUE_ERROR_MESSAGE = "입력값이 비었거나 null 입니다.";
    private static final String INCORRECT_DIVISION_ERROR_MESSAGE = "0으로 나눌수 없습니다.";
    private static final String INCORRECT_OPERATOR_ERROR_MESSAGE = "올바른 사칙연산자가 아닙니다.";

    public StringCalculator() {
    }

    public static int run(final String inputValue) {
        validateIsBlank(inputValue);
        String[] array = Splitter.split(inputValue);

        int result = Integer.parseInt(array[0]);

        for (int i = 1; i < array.length; i += 2) {
            result = calculate(array[i], result, Integer.parseInt(array[i + 1]));
        }

        return result;
    }

    private static int calculate(final String operator, final int num1, final int num2) {
        return OPERATIONS.getOrDefault(operator, (a, b) -> {
            throw new IllegalArgumentException(INCORRECT_OPERATOR_ERROR_MESSAGE);
        }).applyAsInt(num1, num2);
    }

    private static final Map<String, IntBinaryOperator> OPERATIONS = Map.of(
            PLUS, (a, b) -> a + b,
            MINUS, (a, b) -> a - b,
            MULTIPLE, (a, b) -> a * b,
            DIVISION, (a, b) -> {
                if (b == 0) {
                    throw new IllegalArgumentException(INCORRECT_DIVISION_ERROR_MESSAGE);
                }
                return a / b;
            }
    );

    private static void validateIsBlank(final String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(INCORRECT_VALUE_ERROR_MESSAGE);
        }
    }
}
