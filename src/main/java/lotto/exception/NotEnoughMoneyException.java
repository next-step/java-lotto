package lotto.exception;

public class NotEnoughMoneyException extends IllegalArgumentException {

    public NotEnoughMoneyException(String s) {
        super(s);
    }
}
