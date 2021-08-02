package lotto.exception;

public class InvalidLottoTicketException extends IllegalArgumentException {

    private static final String INVALID_TICKET_MESSAGE = "로또 숫자의 개수가 맞지 않거나 반복된 수가 있습니다.";

    public InvalidLottoTicketException() {
        this(INVALID_TICKET_MESSAGE);
    }

    public InvalidLottoTicketException(String message) {
        super(message);
    }
}
