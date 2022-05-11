package lotto.exceptions;

public class PurchaseLottoTicketException extends IllegalArgumentException {
    public PurchaseLottoTicketException() {
    }

    public PurchaseLottoTicketException(String message) {
        super(message);
    }
}
