package edu.nextstep.lottobonusnumber.exception;

public class PaymentIllegalArgumentException extends CustomException {
    public PaymentIllegalArgumentException() {
    }

    public PaymentIllegalArgumentException(String message) {
        super(message);
    }

    public PaymentIllegalArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public PaymentIllegalArgumentException(Throwable cause) {
        super(cause);
    }

    public PaymentIllegalArgumentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
