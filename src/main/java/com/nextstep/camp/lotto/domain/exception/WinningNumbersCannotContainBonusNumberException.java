package com.nextstep.camp.lotto.domain.exception;

public class WinningNumbersCannotContainBonusNumberException extends RuntimeException {

    private static final String MESSAGE = "당첨 번호는 보너스 번호를 포함할 수 없습니다.";

    public WinningNumbersCannotContainBonusNumberException() {
        super(MESSAGE);
    }
}
