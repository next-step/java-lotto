package cc.oakk.lotto.model;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final LottoNumberRange RANGE = LottoNumberRange.between(1, 45);

    private final int number;

    public LottoNumber(int number) {
        if (!RANGE.isValidNumber(number)) {
            throw new IllegalArgumentException(
                    String.format("%d should be between %d and %d", number, RANGE.getFrom(), RANGE.getTo()));
        }
        this.number = number;
    }

    public int get() {
        return number;
    }

    @Override
    public String toString() {
        return Integer.valueOf(number).toString();
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

    @Override
    public int compareTo(LottoNumber target) {
        return number - target.number;
    }
}
