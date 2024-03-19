package lotto.exception;

import java.text.MessageFormat;

public class IllegalPurchaseAmountException extends RuntimeException {
    public IllegalPurchaseAmountException(int amount) {
        super(MessageFormat.format("잘못된 구매 금액을 입력했습니다. (입력 금액: {0})", amount));
    }
}
