package lotto.step2.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private final int number;

    public LottoNumber(int number) {
        validateNumber(number);

        this.number = number;
    }

    public int number() {
        return number;
    }

    private void validateNumber(final int num) {
        throwExceptionIfValueIsNotValid(num);
    }

    private void throwExceptionIfValueIsNotValid(final Integer num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("lotto num value must be 1 ~ 45");
        }
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

    @Override
    public String toString() {
        return "" + this.number;
    }


    @Override
    public int compareTo(final LottoNumber o) {
        return Integer.compare(this.number, o.number);
    }
}
