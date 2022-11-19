package lotto.domain;

import exception.CustomException;
import lotto.exception.LottoErrorCode;

import java.util.Objects;

public class LottoNumber {

    private final Integer number;

    private LottoNumber(String value) {
        int number = Integer.parseInt(value);
        checkLottoNumber(number);
        this.number = number;
    }

    private LottoNumber(int number) {
        checkLottoNumber(number);
        this.number = number;
    }

    private void checkLottoNumber(Integer number) {
        if (!isValidLottoNumber(number)) {
            throw new CustomException(LottoErrorCode.LOTTO_NUMBER_BAD_REQUEST);
        }
    }

    private boolean isValidLottoNumber(Integer number) {
        return number >= LottoNumberRange.MINIMUM_VALUE
                && number <= LottoNumberRange.MAXIMUM_VALUE;
    }

    public static LottoNumber from(int number) {
        return new LottoNumber(number);
    }

    public static LottoNumber from(LottoNumber lottoNumber) {
        return new LottoNumber(lottoNumber.number);
    }

    public static LottoNumber from(String lottoNumber) {
        return new LottoNumber(lottoNumber);
    }

    public Integer getNumber() {
        return number;
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
        return Integer.toString(number);
    }
}
