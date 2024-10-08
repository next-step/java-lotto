package calculator;

import java.util.Map;
import java.util.function.IntBinaryOperator;

public class StringCalculator {
    private static final String INCORRECT_VALUE_ERROR_MESSAGE = "입력값이 비었거나 null 입니다.";

    public StringCalculator() {
    }

    public static int run(final String inputValue) {
        validateIsBlank(inputValue);
        String[] array = Splitter.split(inputValue);

        int result = Integer.parseInt(array[0]);

        for (int i = 1; i < array.length; i += 2) {
            result = Operation.calculate(array[i], result, Integer.parseInt(array[i + 1]));
        }

        return result;
    }

    private static void validateIsBlank(final String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(INCORRECT_VALUE_ERROR_MESSAGE);
        }
    }
}
