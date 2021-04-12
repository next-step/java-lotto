package lotto.exception;

public class MoneyNotEnoughException extends RuntimeException {
    public MoneyNotEnoughException() {
        super("Money is not enough to buy lotto");
    }

    public MoneyNotEnoughException(String s) {
        super(s);
    }
}
