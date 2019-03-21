package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private Integer value;

    public LottoNumber(Integer value) {
        if (value < 1) {
            throw new IllegalArgumentException("1 OR MORE");
        }

        if (value > 45) {
            throw new IllegalArgumentException("45 OR LESS");
        }

        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "value=" + value +
                '}';
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
