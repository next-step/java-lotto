package com.seok2.lotto.exception;

public class LottoDuplicateNumberException extends RuntimeException {

    private static final String ERROR_MSG = "중복 된 로또 번호를 선택 할 수 없습니다.";

    public LottoDuplicateNumberException() {
        super(ERROR_MSG);
    }
}
