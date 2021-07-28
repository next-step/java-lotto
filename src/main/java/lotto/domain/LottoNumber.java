package lotto.domain;

import lotto.exception.OutOfRangeException;

public class LottoNumber extends Number {
    private final int value;

    public LottoNumber(int value) {
        this.value = value;

        validNumber();
    }

    private void validNumber() {
        if (value < 1 || value > 45) {
            throw new OutOfRangeException();
        }
    }

    @Override
    public int intValue() {
        return value;
    }

    @Override
    public long longValue() {
        return intValue();
    }

    @Override
    public float floatValue() {
        return intValue();
    }

    @Override
    public double doubleValue() {
        return intValue();
    }
}
