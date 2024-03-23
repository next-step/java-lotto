package lotto.exception;

import java.text.MessageFormat;

public class IllegalPurchaseAmountException extends IllegalArgumentException {
    public IllegalPurchaseAmountException(int validAmount, int amount) {
        super(MessageFormat.format("잘못된 구매 금액을 입력했습니다. 구매 금액은 최소 {0}원 이상입니다. (입력 금액: {1})", validAmount, amount));
    }
}
