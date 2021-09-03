package lotto.domain;

import java.util.Objects;
import lotto.constraint.Constraint;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int number;

    public LottoNumber(final int number) {
        validRangeCheck(number);
        this.number = number;
    }

    private void validRangeCheck(final int number) {
        if (number < Constraint.MIN_NUMBER || number > Constraint.MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1과 45사이 값만 가능합니다.");
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(final LottoNumber o) {
        return Integer.compare(this.number, o.number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
