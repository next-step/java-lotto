package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{
    private final int value;

    public LottoNumber(int value) {
        if (value < 1 || value > 45) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    public int getValue() {
        return value;
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

    @Override
    public int compareTo(LottoNumber o) {
        if (this.value < o.getValue()) {
            return -1;
        }

        if (this.value > o.getValue()) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
