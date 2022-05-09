package step2.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{
    private int value;

    public LottoNumber(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(value, o.value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static LottoNumber create(String input) {
        return new LottoNumber(Integer.parseInt(input));
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
}
