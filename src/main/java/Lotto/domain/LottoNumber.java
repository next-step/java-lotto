package Lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int LOTTO_START_NUMBER = 0;
    public static final int LOTTO_LAST_NUMBER = 45;

    private final int number;

    private LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    public static LottoNumber newInstance(int number) {
        return new LottoNumber(number);
    }

    private void validateNumber(final int number) {
        if (LOTTO_START_NUMBER > number || LOTTO_LAST_NUMBER < number) {
            throw new IllegalArgumentException("Not Allowed Number: " + number);
        }
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
