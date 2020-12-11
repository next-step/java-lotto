package com.nextstep.lotto.domain.exceptions;

public class InvalidLottoTicketException extends RuntimeException {
    public InvalidLottoTicketException(String message) {
        super(message);
    }
}
