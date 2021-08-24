package edu.nextstep.lottobonusnumber.exception;

import edu.nextstep.lottobonusnumber.exception.CustomException;

public class PaymentIllegalArgumentException extends CustomException {
    public PaymentIllegalArgumentException(String message) {
        super(message);
    }
}
