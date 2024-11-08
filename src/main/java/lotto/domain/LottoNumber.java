package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;

    private final int value;

    public LottoNumber(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException("로또번호는 1 이상 45 이하의 값이어야 합니다.");
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
        return "" + value;
    }
}
