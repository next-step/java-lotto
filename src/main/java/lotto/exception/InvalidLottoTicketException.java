package lotto.exception;

public class InvalidLottoTicketException extends RuntimeException {

    private static final String INVALID_LOTTO_TICKET_MESSAGE = "로또 번호 갯수가 맞지 않습니다.";

    public InvalidLottoTicketException() {
        super(INVALID_LOTTO_TICKET_MESSAGE);
    }

}
