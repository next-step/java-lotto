package lotto.exception;

public class WrongLottoTicketException extends IllegalArgumentException {

    public WrongLottoTicketException(String s) {
        super(s);
    }
}
