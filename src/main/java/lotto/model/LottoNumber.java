package lotto.model;

import java.util.Objects;

public class LottoNumber {
    private final int number;

    public LottoNumber(int number) {
        this.number = number;
    }

    public int getValue() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber lottoNumber1 = (LottoNumber) o;
        return number == lottoNumber1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
