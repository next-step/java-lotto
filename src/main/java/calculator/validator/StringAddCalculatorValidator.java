package calculator.validator;

public final class StringAddCalculatorValidator {
    private static final int ZERO = 0;

    private StringAddCalculatorValidator() {

    }

    public static void checkLessThanZero(int number) {
        if (number < ZERO) {
            throw new IllegalArgumentException("0보다 값이 작습니다.");
        }
    }
}
