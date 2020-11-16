package lotto.domain.exception;

public class NotValidLottoTicketException extends RuntimeException{

    private static final String MESSAGE = "로또 티켓은 1개 이상이어야 합니다";

    public NotValidLottoTicketException(){
        super(MESSAGE);
    }
}
