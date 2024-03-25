package lotto.error.exception;

import java.text.MessageFormat;
import lotto.error.ErrorMessage;

public class PurchaseAmountException extends RuntimeException {

    public PurchaseAmountException(Object parameter) {
        super(MessageFormat.format("{0} 입력값: {1}", ErrorMessage.PURCHASE_AMOUNT_MOD.getMessage(),
            parameter));
    }
}
