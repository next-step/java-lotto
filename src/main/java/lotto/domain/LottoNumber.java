package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    public static final int MIN = 1;
    public static final int MAX = 45;

    private final int number;

    public LottoNumber(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException("1 ~ 45 사이의 숫자만 사용할 수 있습니다.");
        }

        this.number = number;
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

        return this.number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}

