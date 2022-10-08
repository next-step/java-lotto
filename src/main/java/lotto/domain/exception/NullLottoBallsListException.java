package lotto.domain.exception;

public class NullLottoBallsListException extends RuntimeException {

    public NullLottoBallsListException() {
        super("로또볼 리스트는 null 이면 안됩니다.");
    }
}
