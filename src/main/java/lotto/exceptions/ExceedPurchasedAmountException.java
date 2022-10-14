package lotto.exceptions;

public class ExceedPurchasedAmountException extends IllegalArgumentException {
    public ExceedPurchasedAmountException(String msg) {
        super(msg);
    }
}
