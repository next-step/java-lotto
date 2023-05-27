package lotto.domain;

import java.util.*;

public class LottoNumber {

    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int MIN_LOTTO_NUMBER = 1;
    private final Integer number;

    public LottoNumber(Integer number) {
        validLottoNumberRange(number);
        this.number = number;
    }

    private void validLottoNumberRange(Integer number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1이상 45 이하여야 합니다");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "" + number;
    }
}
