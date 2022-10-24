package lotto.domain.exception;

public class NullTicketBoxException extends RuntimeException {

    public NullTicketBoxException() {
        super("합칠 티켓박스는 null 이어선 안됩니다.");
    }
}
