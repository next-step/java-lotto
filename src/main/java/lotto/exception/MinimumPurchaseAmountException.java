package lotto.exception;

public class MinimumPurchaseAmountException extends RuntimeException {
    private final static String MESSAGE = "최소 구매금액은 1000원 입니다.";

    public MinimumPurchaseAmountException() {
        super(MESSAGE);
    }
}
