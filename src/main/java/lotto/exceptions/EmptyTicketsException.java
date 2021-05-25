package lotto.exceptions;

import lotto.enums.ErrorMessage;

public class EmptyTicketsException extends RuntimeException {

    public EmptyTicketsException() {
        this(ErrorMessage.EMPTY_TICKETS.toString());
    }

    public EmptyTicketsException(String message) {
        super(message);
    }

}
