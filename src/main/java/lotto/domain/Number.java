package lotto.domain;

import lotto.constant.Constant;

import java.util.Objects;

public class Number {
    private int number;

    public Number(int number) {
        checkRange(number);
        this.number = number;
    }

    private void checkRange(int number) {
        if (number < Constant.MIN_LOTTO || number > Constant.MAX_LOTTO) {
            throw new IllegalArgumentException("로또 숫자는 1 이상 45 이하여야 합니다.");
        }
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return this.number;
    }
}
