package com.nextstep.camp.lotto.domain.exception;

public class LottoAmountNullException extends RuntimeException {

    private static final String MESSAGE = "로또 구매 금액이 입력되지 않았습니다.";

    public LottoAmountNullException() {
        super(MESSAGE);
    }
}
