package lotto.exception;

public class TicketPriceOutOfBoundException extends RuntimeException{
    public TicketPriceOutOfBoundException(String message) {
        super(message);
    }
}
