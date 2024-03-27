package lotto.domain;

import lotto.constant.Constant;

import java.util.Objects;
import java.util.Random;

public class LottoNumber {
    private final int number;

    public LottoNumber(int number) {
        checkRange(number);
        this.number = number;
    }

    private void checkRange(int number) {
        if (number < Constant.MIN_LOTTO || number > Constant.MAX_LOTTO) {
            throw new IllegalArgumentException("로또 숫자는 1 이상 45 이하여야 합니다.");
        }
    }

    public int getLottoNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return this.number;
    }
}
