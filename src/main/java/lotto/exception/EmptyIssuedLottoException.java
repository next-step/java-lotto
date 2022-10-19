package lotto.exception;

public class EmptyIssuedLottoException extends RuntimeException {

    public EmptyIssuedLottoException() {
        super();
    }

    public EmptyIssuedLottoException(String message) {
        super(message);
    }

    public EmptyIssuedLottoException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyIssuedLottoException(Throwable cause) {
        super(cause);
    }

    protected EmptyIssuedLottoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
