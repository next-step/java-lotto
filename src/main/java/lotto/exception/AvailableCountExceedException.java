package lotto.exception;

public class AvailableCountExceedException extends RuntimeException {

    public AvailableCountExceedException() {
        super((ErrorMessage.TICKET_COUNT_EXCEED));
    }
}
