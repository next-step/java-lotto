package lotto.domain.exception;

public class NullTicketsException extends RuntimeException {

    public NullTicketsException() {
        super("티켓뭉치는 null 이면 안됩니다.");
    }
}
