package com.seok2.lotto.exception;

public class LottoLengthException extends RuntimeException {

    private static final String ERROR_MSG = "로또 번호는 6개보다 크거나 작을 수 없습니다.";

    public LottoLengthException() {
        super(ERROR_MSG);
    }
}
