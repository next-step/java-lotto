package com.seok2.lotto.exception;

public class OutOfLottoLengthException extends RuntimeException {

    private static final String LOTTO_LENGTH_ERROR_MSG = "로또 번호는 6개보다 많을 수 없습니다.";

    public OutOfLottoLengthException() {
        super(LOTTO_LENGTH_ERROR_MSG);
    }
}
