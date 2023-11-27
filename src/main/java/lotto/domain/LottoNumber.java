package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    final static int MIN_NUMBER = 1;
    final static int MAX_NUMBER = 45;

    private final int value;

    public LottoNumber(int value) {
        validation(value);
        this.value = value;
    }

    public static LottoNumber from(int number) {
        return new LottoNumber(number);
    }

    private void validation(int value) {
        if (value < MIN_NUMBER) {
            throw new IllegalArgumentException("로또의 숫자는 최소 1입니다.");
        }
        if (value > MAX_NUMBER) {
            throw new IllegalArgumentException("로또의 숫자는 최대 45입니다.");
        }
    }

    public boolean equalNumber(int compareInteger) {
        return this.value == compareInteger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
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
