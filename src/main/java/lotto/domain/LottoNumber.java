package lotto.domain;

import lotto.exception.OutOfRangeException;

public class LottoNumber extends Number {
    private final int value;

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    public LottoNumber(int value) {
        this.value = value;

        validNumber();
    }

    private void validNumber() {
        if (value < MIN_VALUE || value > MAX_VALUE) {
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
