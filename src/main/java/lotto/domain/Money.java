package lotto.domain;

import lotto.exception.OutOfRangeException;

public class Money extends Number {
    private final int value;

    private static final int MIN_VALUE = 0;

    public Money(int value) {
        this.value = value;

        validNumber();
    }

    public static Money empty() {
        return InnerClazz.EMPTY;
    }

    private void validNumber() {
        if (value < MIN_VALUE) {
            throw new OutOfRangeException("돈은 음수일 수 없습니다.");
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

    private static class InnerClazz {
        private static Money EMPTY = new Money(MIN_VALUE);
    }
}
