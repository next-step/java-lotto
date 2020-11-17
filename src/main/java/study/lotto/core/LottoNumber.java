package study.lotto.core;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private final int value;

    public LottoNumber(int value) {
        if (value < MIN_LOTTO_NUMBER || value > MAX_LOTTO_NUMBER) {
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
        return value - lottoNumber.value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
