package lotto.domain.exception;

public class NullPurchasePriceException extends RuntimeException {

    public NullPurchasePriceException() {
        super("투입금액은 null 이어선 안됩니다.");
    }
}
