package lotto.domain;

import lotto.exception.InvalidLottoNumberException;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN = 1;
    public static final int MAX = 45;

    private int number;

    private LottoNumber(final int number) {
        this.number = number;
    }

    // 복사 생성자
    private LottoNumber(final LottoNumber clone) {
        this.number = clone.number;
    }

    public static LottoNumber valueOf(final int number) {
        checkAvailableNumber(number);
        return new LottoNumber(number);
    }

    public static LottoNumber clone(final LottoNumber clone) {
        return new LottoNumber(clone);
    }

    private static void checkAvailableNumber(final int number) {
        if (number < MIN || number > MAX) {
            throw new InvalidLottoNumberException(number);
        }
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(final LottoNumber o) {
        return Integer.compare(this.number, o.number);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
