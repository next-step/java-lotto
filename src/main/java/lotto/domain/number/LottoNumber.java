package lotto.domain.number;

import lotto.domain.LottoConstant;

import java.util.Objects;

public class LottoNumber {

    private final int number;

    public LottoNumber(int number) {
        validateLottoNumber(number);
        this.number = number;
    }

    public static void validateLottoNumber(int number) {
        if (number < LottoConstant.MIN_LOTTO_NUMBER || LottoConstant.MAX_LOTTO_NUMBER < number) {
            throw new IllegalArgumentException(LottoConstant.ILLEGAL_LOTTO_NUMBER);
        }
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
