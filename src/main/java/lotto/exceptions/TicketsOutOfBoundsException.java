package lotto.exceptions;

import lotto.enums.ErrorMessage;

public class TicketsOutOfBoundsException extends RuntimeException {

    public TicketsOutOfBoundsException() {
        this(ErrorMessage.TICKETS_OUT_OF_BOUNDS.toString());
    }

    public TicketsOutOfBoundsException(String message) {
        super(message);
    }
}
