package dev.dahye.lotto.domain;

import java.util.Objects;

public class LottoNumber {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    private final int number;

    private LottoNumber(final int number) {
        validateNumber(number);
        this.number = number;
    }

    public static LottoNumber of(final int number) {
        return new LottoNumber(number);
    }

    public static void validateNumber(int number) {
        if (number > MAX_VALUE || number < MIN_VALUE) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45의 숫자만 가능합니다.");
        }
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
