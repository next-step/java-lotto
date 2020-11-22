package exception;

public class InvalidBonusNumberException extends Exception {
    public InvalidBonusNumberException() {
    }

    public InvalidBonusNumberException(String message) {
        super(message);
    }
}
