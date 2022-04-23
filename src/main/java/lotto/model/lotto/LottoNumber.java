package lotto.model.lotto;

import lotto.exception.InvalidLottoNumberException;

import java.util.Objects;

public class LottoNumber {

    private static final int MIN_LOTTO_NUMBER = 1;

    private static final int MAX_LOTTO_NUMBER = 45;

    private final int value;

    public LottoNumber(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value > MAX_LOTTO_NUMBER || value < MIN_LOTTO_NUMBER) {
            throw new InvalidLottoNumberException(value);
        }
    }

    public boolean isBonusNumber(LottoNumber lottoNumber) {
        return this.equals(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber lottoNumber = (LottoNumber) o;
        return value == lottoNumber.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}
