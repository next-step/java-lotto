package model;

import java.util.Objects;

public class LottoNumber {

    private static final int MIN_BONUS_NUMBER = 1;
    private static final int MAX_BONUS_NUMBER = 45;

    private final int value;

    public LottoNumber(final int value) {
        validate(value);
        this.value = value;
    }

    private void validate(final int value) {
        if (value < MIN_BONUS_NUMBER || value > MAX_BONUS_NUMBER) {
            throw new IllegalArgumentException("로또 번호의 범위는 1에서 45 사이의 숫자여야 합니다.");
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
