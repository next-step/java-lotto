package com.jaeyeonling.lotto.exception;

import com.jaeyeonling.lotto.domain.Lotto;

public class InvalidCountOfLottoNumberException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "Lotto 생성 시 LottoNumber 의 갯수는 %d 개를 만족해야 합니다. (입력 갯수: %d)";

    public InvalidCountOfLottoNumberException(final int inputLottoNumber) {
        super(String.format(ERROR_MESSAGE, Lotto.COUNT_OF_LOTTO_NUMBER, inputLottoNumber));
    }
}
