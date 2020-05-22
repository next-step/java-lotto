package lotto.domain.shop.exceptions;

public class OutOfBoundMoneyCreationException extends RuntimeException {
    public OutOfBoundMoneyCreationException(String message) {
        super(message);
    }
}
