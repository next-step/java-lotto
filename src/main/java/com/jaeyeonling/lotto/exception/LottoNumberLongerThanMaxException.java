package com.jaeyeonling.lotto.exception;

import com.jaeyeonling.lotto.config.Env;

public class LottoNumberLongerThanMaxException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "LottoNumber 의 값은 %d보다 클 수 없습니다. (입력 값: %d)";

    public LottoNumberLongerThanMaxException(final int inputLottoNumber) {
        super(String.format(ERROR_MESSAGE, Env.MAX_LOTTO_NUMBER, inputLottoNumber));
    }
}
