package com.nextstep.camp.lotto.domain.exception;

public class LottoAmountCannotBeZeroOrNegativeException extends RuntimeException {

    private static final String MESSAGE = "로또 구입 금액은 0보다 커야 합니다.";

    public LottoAmountCannotBeZeroOrNegativeException() {
        super(MESSAGE);
    }
}
