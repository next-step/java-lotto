package lotto.exception;

public class WrongTicketCountException extends IllegalArgumentException {

    public WrongTicketCountException(String s) {
        super(s);
    }
}
