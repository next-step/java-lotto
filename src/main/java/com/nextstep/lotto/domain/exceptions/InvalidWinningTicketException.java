package com.nextstep.lotto.domain.exceptions;

public class InvalidWinningTicketException extends RuntimeException {
    public InvalidWinningTicketException(String message) {
        super(message);
    }
}
