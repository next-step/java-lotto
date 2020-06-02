package step2.model;

import java.util.Objects;

public class LottoNumber {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    private final int value;

    private LottoNumber(int number) {
        if (isInvalidRange(number)) {
            throw new IllegalArgumentException("1 ~ 45 사이의 숫자만 입력이 가능합니다.");
        }

        this.value = number;
    }

    private boolean isInvalidRange(int number) {
        return number < MIN_VALUE || number > MAX_VALUE;
    }

    public static LottoNumber valueOf(int number) {
        return new LottoNumber(number);
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
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
