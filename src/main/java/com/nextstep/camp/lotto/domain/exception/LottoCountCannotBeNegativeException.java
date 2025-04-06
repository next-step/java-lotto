package com.nextstep.camp.lotto.domain.exception;

public class LottoCountCannotBeNegativeException extends RuntimeException {

    private static final String MESSAGE = "로또 티켓 수는 0보다 작을 수 없습니다.";

    public LottoCountCannotBeNegativeException() {
        super(MESSAGE);
    }
}
