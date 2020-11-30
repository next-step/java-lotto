package exception;

public class DevidedByInvalidMoneyException extends RuntimeException {
    public DevidedByInvalidMoneyException() {
    }

    public DevidedByInvalidMoneyException(String message) {
        super(message);
    }
}
