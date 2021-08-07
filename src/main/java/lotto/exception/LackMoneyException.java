package lotto.exception;

public class LackMoneyException extends RuntimeException {
    public LackMoneyException() {
        super("don't have enough money.");
    }

    public LackMoneyException(String message) {
        super(message);
    }
}
