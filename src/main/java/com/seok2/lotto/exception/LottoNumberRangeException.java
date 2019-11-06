package com.seok2.lotto.exception;

public class LottoNumberRangeException extends RuntimeException {

    private static final String LOTTO_NUMBER_RANGE_ERROR_MSG = "로또 번호는 1보다 크고 45보다 작아야 합니다.";

    public LottoNumberRangeException() {
        super(LOTTO_NUMBER_RANGE_ERROR_MSG);
    }
}
