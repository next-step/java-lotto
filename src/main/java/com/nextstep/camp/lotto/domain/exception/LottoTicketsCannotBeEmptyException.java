package com.nextstep.camp.lotto.domain.exception;

public class LottoTicketsCannotBeEmptyException extends RuntimeException {

    private static final String MESSAGE = "로또 티켓은 비어있을 수 없습니다.";

    public LottoTicketsCannotBeEmptyException() {
        super(MESSAGE);
    }
}
