package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    public static final int MAX_BOUND = 45;
    public static final int MIN_BOUND = 1;
    private static final String OUT_OF_RANGE_ERROR_MESSAGE = "로또 숫자가 범위 밖입니다.";

    private final int value;

    private LottoNumber(int value) {
        this.value = value;
    }

    public static LottoNumber valueOf(int value) {
        if (value < MIN_BOUND || value > MAX_BOUND) {
            throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
        }
        return new LottoNumber(value);
    }

    public int value() {
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
        return Objects.hashCode(value);
    }
}
