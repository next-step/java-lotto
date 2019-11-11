package com.seok2.lotto.exception;

public class EmptyLotteriesException extends RuntimeException {

    private static final String ERROR_MSG = "최소 한장 이상의 로또를 구매해야 합니다.";

    public EmptyLotteriesException() {
        super(ERROR_MSG);
    }

}
