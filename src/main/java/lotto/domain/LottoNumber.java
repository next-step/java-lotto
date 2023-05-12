package lotto.domain;

import lotto.util.LottoConstants;

import java.util.Objects;

public class LottoNumber {
    private int number;

    public LottoNumber(int number) {
        validateBetweenMinAndMax(number);
        this.number = number;
    }

    private void validateBetweenMinAndMax(int number) {
        if(LottoConstants.LOTTO_MIN_NUMBER > number || LottoConstants.LOTTO_MAX_NUMBER < number) {
            throw new IllegalArgumentException("로또 번호는 1~45 입니다. 입력값 : " + number);
        }
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public String toString() {
        return "" + getNumber();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o instanceof Integer) return number == (Integer) o;
        if (getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
