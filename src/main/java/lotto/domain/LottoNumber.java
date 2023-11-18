package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    private int value;

    public LottoNumber(int value) {
        this.value = value;
    }

    public String findNumber() {
        return String.valueOf(value);
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
