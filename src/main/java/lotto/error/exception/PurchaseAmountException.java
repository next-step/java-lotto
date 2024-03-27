package lotto.error.exception;

import java.text.MessageFormat;

public class PurchaseAmountException extends RuntimeException {

    public PurchaseAmountException(Object parameter) {
        super(MessageFormat.format("{0} 입력값: {1}", "구매금액은 1000원 단위로 가능합니다.",
            parameter));
    }
}
