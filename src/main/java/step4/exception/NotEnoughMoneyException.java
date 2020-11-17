package step4.exception;

public class NotEnoughMoneyException extends RuntimeException{
    public NotEnoughMoneyException() { }

    public NotEnoughMoneyException(String message) {
        super(message);
    }
}
