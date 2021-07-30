package lotto.domain;

import lotto.exception.OutOfRangeException;

import java.util.Objects;

public final class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    private final int value;

    public LottoNumber(int value) {
        validateValue(value);

        this.value = value;
    }

    private void validateValue(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new OutOfRangeException("로또 번호는 1부터 45까지의 숫자만 유효합니다.");
        }
    }

    @Override
    public boolean equals(Object compareValue) {
        if (!(compareValue instanceof LottoNumber)) {
            return false;
        }
        LottoNumber that = (LottoNumber) compareValue;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public int compareTo(LottoNumber compareValue) {
        return Integer.compare(value, compareValue.value);
    }
}
