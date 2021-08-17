package step3.lotto.exception;

public class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException(String msg) {
        super(msg);
    }
}
