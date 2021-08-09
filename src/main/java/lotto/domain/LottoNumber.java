package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private static final int MIN = 1;
    private static final int MAX = 45;

    private int value;

    public LottoNumber(int value) {
        if (value < MIN || value > MAX) {
            throw new IllegalArgumentException("로또 번호는 1~45까지 입력 가능합니다.");
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
    public String toString() {
        return String.valueOf(value);
    }
}
