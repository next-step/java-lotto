package edu.nextstep.lottobonusnumber.exception;

public class NumbersIllegalArgumentException extends CustomException {
    public NumbersIllegalArgumentException() {
    }

    public NumbersIllegalArgumentException(String message) {
        super(message);
    }

    public NumbersIllegalArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public NumbersIllegalArgumentException(Throwable cause) {
        super(cause);
    }

    public NumbersIllegalArgumentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
