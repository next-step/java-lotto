package lotto_auto.model;

import lotto_auto.ErrorMessage;

public class LottoNumber {

    private static final Integer LOTTO_NUMBER_MIN_RANGE = 0;
    private static final Integer LOTTO_NUMBER_MAX_RANGE = 45;
    private final int number;

    public LottoNumber(int number) {
        ThrowIfInvalidLottoNumberRange(number);
        this.number = number;
    }

    private void ThrowIfInvalidLottoNumberRange(int number) {
        if (number <= LOTTO_NUMBER_MIN_RANGE || number >= LOTTO_NUMBER_MAX_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER);
        }
    }

    public boolean equals(LottoNumber obj) {
        return this.number == obj.number;
    }

    public int getNumber() {
        return number;
    }
}
