package lotto.domain;

import lotto.constant.ErrorMessage;

public class LottoNumber {

    public static final int NUMBER_MIN_RANGE = 1;
    public static final int NUMBER_MAX_RANGE = 45;
    private final int value;

    public LottoNumber(int value) {
        valid(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private void valid(int value) {
        if (value < NUMBER_MIN_RANGE || value > NUMBER_MAX_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_IS_OUT_OF_RANGE);
        }
    }

}
