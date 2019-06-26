package com.jaeyeonling.lotto.exception;

public class EmptyLottoNumberException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "LottoNumbers 는 빈값 일 수 없습니다.";

    public EmptyLottoNumberException() {
        super(ERROR_MESSAGE);
    }
}

