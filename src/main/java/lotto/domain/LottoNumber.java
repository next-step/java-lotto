package lotto.domain;

import lotto.exception.InvalidNumberException;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public int value;

    public LottoNumber(int value) {
        checkInvalidNumber(value);
        this.value = value;
    }

    private void checkInvalidNumber(int value) {
        if(value < MIN_NUMBER || value > MAX_NUMBER) {
            throw new InvalidNumberException();
        }
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.value, o.value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
