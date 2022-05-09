package Lotto.exception;

public class TooSmallMoneyException extends RuntimeException{

    public TooSmallMoneyException(String message) {
        super(message);
    }
}
