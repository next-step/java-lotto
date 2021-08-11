package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{
    public int getValue() {
        return value;
    }

    private final int value;

    public LottoNumber(int value) {
        this.value = value;
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
    public int compareTo(LottoNumber lottoNumber) {
        return Integer.compare(this.value, lottoNumber.value);
    }
}
