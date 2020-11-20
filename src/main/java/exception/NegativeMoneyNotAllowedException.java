package exception;

public class NegativeMoneyNotAllowedException extends Exception {
    public NegativeMoneyNotAllowedException() {
    }

    public NegativeMoneyNotAllowedException(String message) {
        super(message);
    }
}
