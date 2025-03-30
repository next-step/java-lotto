package step4.lotto.exception;

public class LottoTicketInvalidSizeException extends LottoTicketException {

    private static final String MESSAGE = "로또 티켓의 크기가 6이 아닙니다. 중복된 번호가 있거나, 번호를 너무 많이 입력했거나, 누락된 번호가 있을 수 있습니다.";

    public LottoTicketInvalidSizeException() {
        super(MESSAGE);
    }

}
