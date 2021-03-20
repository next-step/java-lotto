package lotto.step1.domain;

import lotto.step1.exception.StringAddCalculatorException;

public class Number {

    private static final String NEGATIVE_NUMBER_IS_NOT_ALLOWED = "음수값은 올 수 없습니다.";
    private final int number;

    private Number(final int number) {
        if (number < 0) {
            throw new StringAddCalculatorException(NEGATIVE_NUMBER_IS_NOT_ALLOWED);
        }

        this.number = number;
    }

    public static Number of(final int number) {
        return new Number(number);
    }
}
