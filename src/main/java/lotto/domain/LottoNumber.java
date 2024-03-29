package lotto.domain;

import lotto.constant.Constants;

public class LottoNumber {
    private int number;

    public LottoNumber(final int number) {
        checkLottoNumberRange(number);
        this.number = number;
    }

    private void checkLottoNumberRange(int number) {
        if (number < Constants.MIN_LOTTO || number > Constants.MAX_LOTTO) {
            throw new IllegalArgumentException("로또는 1~45 사이의 값이어야 합니다.");
        }
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof LottoNumber)) return false;
        LottoNumber that = (LottoNumber) object;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return this.number;
    }
}
