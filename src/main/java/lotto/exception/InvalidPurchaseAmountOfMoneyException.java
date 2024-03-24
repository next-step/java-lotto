package lotto.exception;

public class InvalidPurchaseAmountOfMoneyException extends IllegalArgumentException {
    private static final String WRONG_PURCHASE_AMOUNT_MESSAGE = "(%s): 잘못된 구입금액입니다.";

    public InvalidPurchaseAmountOfMoneyException(String wrongInput) {
        super(String.format(WRONG_PURCHASE_AMOUNT_MESSAGE, wrongInput));
    }
}
