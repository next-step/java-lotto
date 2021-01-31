package lotto;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int NUM_LEFT_BOUND = 1;
    private static final int NUM_RIHGT_BOUND = 45;

    private Integer number;

    public LottoNumber(int number) {
        if (number < NUM_LEFT_BOUND || number > NUM_RIHGT_BOUND) {
            throw new RuntimeException();
        }
        this.number = number;
    }

    public Integer getLottoNumber() {
        return number;
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
    public int compareTo(LottoNumber other) {
        return number.compareTo(other.number);
    }
}
