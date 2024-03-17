package lotto.exception;

public class InvalidLottoException extends RuntimeException {

    public InvalidLottoException(String message) {
        super(message);
    }

    public InvalidLottoException(String message, Throwable cause) {
        super(message, cause);
    }
}
