package com.seok2.lotto.exception;

public class LottoOutOfBoundException extends RuntimeException {

    private static final String ERROR_MSG = "로또 번호는 1 ~ 45 사이의 숫자여야 합니다.";

    public LottoOutOfBoundException() {
        super(ERROR_MSG);
    }
}
