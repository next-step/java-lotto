package lotto.exception;

public class InvalidInputToGenerateLottos extends RuntimeException {
    public InvalidInputToGenerateLottos() {
    }

    public InvalidInputToGenerateLottos(String message) {
        super(message);
    }

    public InvalidInputToGenerateLottos(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidInputToGenerateLottos(Throwable cause) {
        super(cause);
    }

    public InvalidInputToGenerateLottos(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
