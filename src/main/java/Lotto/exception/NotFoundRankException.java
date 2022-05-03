package Lotto.exception;

public class NotFoundRankException extends RuntimeException {

    public NotFoundRankException() {
    }

    public NotFoundRankException(String msg) {
        super(msg);
    }
}
