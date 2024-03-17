package lotto.model;

import lotto.exception.InvalidLottoException;

import java.util.Objects;

import static lotto.model.LottoNumbers.MAX_NUMBER;
import static lotto.model.LottoNumbers.MIN_NUMBER;

public class LottoNumber {
    private final int number;

    public LottoNumber(int number) {
        assertInvalidNumber(number);

        this.number = number;
    }

    private void assertInvalidNumber(int number) {
        if (number < MIN_NUMBER || MAX_NUMBER < number) {
            throw new InvalidLottoException("로또 번호는 " + MIN_NUMBER + "~" + MAX_NUMBER + " 사이의 숫자만 선택 가능합니다");
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        LottoNumber that = (LottoNumber) other;
        return number == that.number;
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
