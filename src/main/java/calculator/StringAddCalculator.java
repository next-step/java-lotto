package calculator;

public class StringAddCalculator {
    private static final String INCORRECT_VALUE_ERROR_MESSAGE = "입력값이 비었거나 null 입니다.";

    public static void splitAndCalculate(final String value) {
        validateIsBlank(value);
    }

    private static void validateIsBlank(final String value) {
        if(value == null || value.isBlank()) {
            throw new IllegalArgumentException(INCORRECT_VALUE_ERROR_MESSAGE);
        }
    }
}
