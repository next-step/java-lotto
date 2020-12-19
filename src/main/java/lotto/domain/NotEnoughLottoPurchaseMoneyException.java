package lotto.domain;

public class NotEnoughLottoPurchaseMoneyException extends RuntimeException {
    public NotEnoughLottoPurchaseMoneyException(String message) {
        super(message);
    }
}
