package lotto.domain;

import lotto.domain.exception.NotNumberStringException;
import lotto.domain.exception.OutOfRangeLottoNumberException;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final int value;

    public LottoNumber(int value) {
        validateRange(value);
        this.value = value;
    }

    public LottoNumber(String value) {
        this(parseInt(value));
    }

    private void validateRange(final int value) {
        if (value < MIN_NUMBER || value > MAX_NUMBER) {
            throw OutOfRangeLottoNumberException.getInstance();
        }
    }

    private static int parseInt(String stringValue) {
        try {
            return Integer.parseInt(stringValue);
        } catch (NumberFormatException e) {
            throw NotNumberStringException.getInstance();
        }
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.value - o.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
