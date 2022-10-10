package lotto.domain.exception;

public class InvalidTicketsException extends RuntimeException {

    public InvalidTicketsException() {
        super("티켓뭉치는 null 이거나 중복 티켓을 가지면 안됩니다.");
    }
}
