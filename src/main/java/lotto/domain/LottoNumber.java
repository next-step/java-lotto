package lotto.domain;

import lotto.exception.OutOfRangeException;

public class LottoNumber extends Number {
    private final int value;

    public LottoNumber(int value) {
        this.value = value;
    }

    private void validNumber() {
        if (value < 1 || value > 45) {
            throw new OutOfRangeException();
        }
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }
}
