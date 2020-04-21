package lotto.exception;

public class InvalidManualLottoCountException extends RuntimeException {
    public InvalidManualLottoCountException() {
    }

    public InvalidManualLottoCountException(String message) {
        super(message);
    }

    public InvalidManualLottoCountException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidManualLottoCountException(Throwable cause) {
        super(cause);
    }

    public InvalidManualLottoCountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
