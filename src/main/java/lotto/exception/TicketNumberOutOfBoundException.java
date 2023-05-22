package lotto.exception;

public class TicketNumberOutOfBoundException extends RuntimeException {
    public TicketNumberOutOfBoundException(String message) {
        super(message);
    }
}
