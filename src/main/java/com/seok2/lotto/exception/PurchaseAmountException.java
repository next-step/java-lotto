package com.seok2.lotto.exception;

public class PurchaseAmountException extends RuntimeException {

    private static final String NO_LOTTO_PURCHASED_ERROR_MSG = "수동 구매 수량보다 적은 돈을 지불하였습니다.";

    public PurchaseAmountException() {
        super(NO_LOTTO_PURCHASED_ERROR_MSG);
    }
}