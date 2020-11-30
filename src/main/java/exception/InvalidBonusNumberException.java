package exception;

public class InvalidBonusNumberException extends RuntimeException {
    public InvalidBonusNumberException() {
    }

    public InvalidBonusNumberException(String message) {
        super(message);
    }
}
