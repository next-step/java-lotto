package exception;

public class NegativeMoneyNotAllowedException extends RuntimeException {
    public NegativeMoneyNotAllowedException() {
    }

    public NegativeMoneyNotAllowedException(String message) {
        super(message);
    }
}
