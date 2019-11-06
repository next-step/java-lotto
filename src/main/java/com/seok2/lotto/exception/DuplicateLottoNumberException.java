package com.seok2.lotto.exception;

public class DuplicateLottoNumberException extends RuntimeException {

    private static final String DUPLICATE_NUMBER_ERROR_MSG = "중복 된 번호가 선택되었습니다.";

    public DuplicateLottoNumberException() {
        super(DUPLICATE_NUMBER_ERROR_MSG);
    }
}
