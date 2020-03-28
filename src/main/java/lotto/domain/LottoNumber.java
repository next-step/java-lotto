package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private int number;

    private LottoNumber(final int number) {
        checkAvailableNumber(number);
        this.number = number;
    }

    public static LottoNumber valueOf(final int number) {
        return new LottoNumber(number);
    }

    private void checkAvailableNumber(final int number) {
        if (number < 1 || number > 45) {
            throw new RuntimeException("1 ~ 45 사이의 숫자가 아닙니다.");
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
