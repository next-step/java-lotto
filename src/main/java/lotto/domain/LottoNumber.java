package lotto.domain;

import java.util.Objects;

public final class LottoNumber implements Comparable<LottoNumber> {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final int number;

    public LottoNumber(final int number) {
        validateNumberRange(number);
        this.number = number;
    }

    private void validateNumberRange(int number) {
        if(number < MIN_NUMBER) {
            throw new IllegalArgumentException("cannot be less than "+ MIN_NUMBER);
        }
        if(number > MAX_NUMBER) {
            throw new IllegalArgumentException("cannot be greater than "+ MAX_NUMBER);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int compareTo(final LottoNumber o) {
        return number - o.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
