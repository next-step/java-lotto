package com.seok2.lotto.exception;

public class MinimumLotteriesException extends RuntimeException {

    private static final String NO_LOTTO_PURCHASED_ERROR_MSG = "최소 한 장 이상의 게임을 구매해야 합니다.";

    public MinimumLotteriesException() {
        super(NO_LOTTO_PURCHASED_ERROR_MSG);
    }
}
