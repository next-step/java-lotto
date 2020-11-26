package lotto.domain;

public class NotPurchaseLottoException extends RuntimeException {
    public NotPurchaseLottoException(String message) {
        super(message);
    }
}
