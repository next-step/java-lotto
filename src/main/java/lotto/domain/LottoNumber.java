package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private int number;

    public LottoNumber(final int number) {
        checkAvailableNumber(number);
        this.number = number;
    }

    private void checkAvailableNumber(final int number) {
        if (!(0 < number && number < 46)) {
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
