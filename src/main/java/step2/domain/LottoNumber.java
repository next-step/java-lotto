package step2.domain;

import java.util.Objects;

import static step2.domain.LottoConstant.LOTTO_MAX_NUMBER;
import static step2.domain.LottoConstant.LOTTO_MIN_NUMBER;

public class LottoNumber {
    protected final Integer number;

    protected LottoNumber(Integer number) {
        validateLottoNumber(number);
        this.number = number;
    }

    public static LottoNumber create(final int number) {
        return new LottoNumber(number);
    }

    private void validateLottoNumber(final int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("Lotto 최소 값 : " + LOTTO_MIN_NUMBER + ", 최대 값 : " + LOTTO_MAX_NUMBER);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof LottoNumber)) { return false; }
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
