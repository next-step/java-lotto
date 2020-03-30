package lotto.model.wrapper;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    private Integer number;

    private LottoNumber(final Integer number) {
        this.number = number;
    }

    public static LottoNumber of(final Integer number) {
        validateRange(number);
        return new LottoNumber(number);
    }

    private static void validateRange(final Integer number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("Lotto Ticket must be between 1 and 45.");
        }
    }

    public int toInt() {
        return number;
    }

    @Override
    public String toString() {
        return number.toString();
    }

    @Override
    public int compareTo(LottoNumber o) {
        return number.compareTo(o.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
