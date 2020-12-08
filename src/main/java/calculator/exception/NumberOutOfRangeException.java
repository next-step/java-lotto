package calculator.exception;

import calculator.Number;

public class NumberOutOfRangeException extends CalculatorException {

    private static final String MESSAGE = "숫자는 " + Number.MIN_VALUE + "이상이어야 합니다 (입력 값: %d)";

    public NumberOutOfRangeException(final int input) {
        super(String.format(MESSAGE, input));
    }
}
