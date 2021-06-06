package lotto.exceptions;

import lotto.enums.ErrorMessage;

public class NullTicketsException extends RuntimeException {

    public NullTicketsException() {
        this(ErrorMessage.NULL_TICKETS.toString());
    }

    public NullTicketsException(String message) {
        super(message);
    }

}
