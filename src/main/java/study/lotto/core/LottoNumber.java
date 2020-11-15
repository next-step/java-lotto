package study.lotto.core;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{

    private final Integer value;

    public LottoNumber(int value) {
        if (value < 1 || value > 45) {
            throw new IllegalArgumentException("로또 번호는 1 - 45사이의 숫자만 가능합니다.");
        }

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
        return this.value.compareTo(lottoNumber.value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
