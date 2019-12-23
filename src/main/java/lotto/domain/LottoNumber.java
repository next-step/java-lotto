package lotto.domain;

import lotto.exception.LottoServiceException;

public class LottoNumber {

    private int value;

    private LottoNumber(int value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(int value) {
        if (value < LottoPolicy.LOTTO_MINIMUM_NUMBER || value > LottoPolicy.LOTTO_MAXIMUM_NUMBER)
            throw new LottoServiceException(LottoError.WRONG_LOTTO_RANGE);
    }

    static LottoNumber of(int value) {
        return new LottoNumber(value);
    }

    int getValue() {
        return this.value;
    }

}
