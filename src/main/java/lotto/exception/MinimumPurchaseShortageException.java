package lotto.exception;

public class MinimumPurchaseShortageException extends IllegalArgumentException {
    public MinimumPurchaseShortageException() {
        throw new MinimumPurchaseShortageException("Ticket 은 최소 1개 이상 구매해야하며, 1장은 1000원이다");
    }

    private MinimumPurchaseShortageException(String message) {
    }
}
