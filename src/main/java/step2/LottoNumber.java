package step2;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MIN = 1;
    private static final int MAX = 45;

    private int value;

    private LottoNumber(int value) {
        if (value < MIN || value > MAX) {
            throw new IllegalArgumentException("Lotto number is incorrect");
        }
        this.value = value;
    }

    public static LottoNumber of(int value) {
        return new LottoNumber(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber num = (LottoNumber) o;
        return value == num.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value + "";
    }

    @Override
    public int compareTo(LottoNumber o) {
        return o.value > value ? -1 : 1;
    }
}
