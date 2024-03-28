package step1.config.exception;

import static step1.config.message.ErrorMessage.DIVIDE_BY_ZERO_NOT_ALLOWED;

public class DivideByZeroException extends RuntimeException {
    public DivideByZeroException() {
        super(DIVIDE_BY_ZERO_NOT_ALLOWED.message());
    }
}
