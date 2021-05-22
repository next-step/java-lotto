package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private final int number;

    private LottoNumber(final int number) {
        this.number = number;
    }

    public static LottoNumber from(final int number) {
        validateNumber(number);
        return new LottoNumber(number);
    }

    private static void validateNumber(final int number) {
        if (number > Lotto.NUMBER_MAX_BOUND || number < Lotto.NUMBER_MIN_BOUND) {
            throw new IllegalArgumentException("로또 번호가 유효한 범위를 벗어났습니다.");
        }
    }

    public int getNumber() {
        return number;
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
