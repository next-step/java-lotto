package lotto;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 45;

    private final int number;

    public LottoNumber(int number) {
        if (number <= MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException("Only 1 through 45 can be entered.");
        }
        this.number = number;
    }

    @Override
    public int compareTo(LottoNumber o) {
        if (this.number < o.number) {
            return 1;
        }

        if (this.number == o.number) {
            return 0;
        }

        return -1;
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
