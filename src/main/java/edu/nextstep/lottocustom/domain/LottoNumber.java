package edu.nextstep.lottocustom.domain;

import edu.nextstep.lottocustom.exception.NumbersIllegalArgumentException;

import java.util.Objects;

public class LottoNumber {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final String OUT_OF_RANGE_EXCEPTION_MESSAGE = "지정 가능 숫자 범위 초과. 범위 : " + MIN_NUMBER + " ~ " + MAX_NUMBER;

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        validateOutOfRange(lottoNumber);

        this.lottoNumber = lottoNumber;
    }

    private void validateOutOfRange(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new NumbersIllegalArgumentException(OUT_OF_RANGE_EXCEPTION_MESSAGE);
        }
    }

    public static LottoNumber of(int lottoNumber) {
        return new LottoNumber(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return lottoNumber + "";
    }
}
