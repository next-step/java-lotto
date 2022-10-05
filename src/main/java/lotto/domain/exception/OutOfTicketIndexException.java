package lotto.domain.exception;

public class OutOfTicketIndexException extends RuntimeException {

    public OutOfTicketIndexException() {
        super("잘못된 티켓 인덱스입니다.");
    }

}
