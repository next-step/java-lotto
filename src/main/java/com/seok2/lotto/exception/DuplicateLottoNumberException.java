package com.seok2.lotto.exception;

public class DuplicateLottoNumberException extends RuntimeException {

    private static final String DUPLICATE_NUMBER_ERROR_MSG = "보너스 번호가 이미 선택 된 번호입니다.";

    public DuplicateLottoNumberException() {
        super(DUPLICATE_NUMBER_ERROR_MSG);
    }
}
