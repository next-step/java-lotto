package lotto.exception;

public class NotEnoughTicketCountException extends IllegalArgumentException {

    public NotEnoughTicketCountException(String s) {
        super(s);
    }
}
