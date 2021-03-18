package lotto.step1.domain;

import lotto.step1.exception.StringAddCalculatorException;

public class Number {

    private int number;

    private Number(int number) {
        if (number < 0) {
            throw new StringAddCalculatorException("음수값은 올 수 없습니다.");
        }

        this.number = number;
    }

    public static Number of (int number) {
        return new Number(number);
    }
}
