package lotto.domain;

import java.util.Comparator;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private int value;

    public LottoNumber(int value) {
        this.value = value;
    }

    public static LottoNumber of(int value) {
        return new LottoNumber(value);
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
    public int compareTo(LottoNumber target) {
        return this.value - target.value;
    }

    public int getNumber() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
