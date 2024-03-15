package lotto.model;

import lotto.exception.InvalidLottoException;

import java.util.Objects;

public class LottoNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final int number;

    public LottoNumber(int number) {
        if (number < MIN_NUMBER || MAX_NUMBER < number) {
            throw new InvalidLottoException("로또 번호는 " + MIN_NUMBER + "~" + MAX_NUMBER + " 사이의 숫자만 선택 가능합니다");
        }
        this.number = number;
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
