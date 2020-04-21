package lotto.exception;

public class InvalidLottoNumbersException extends RuntimeException {
    public InvalidLottoNumbersException() {
    }

    public InvalidLottoNumbersException(String message) {
        super(message);
    }

    public InvalidLottoNumbersException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidLottoNumbersException(Throwable cause) {
        super(cause);
    }

    public InvalidLottoNumbersException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
