package step1.exception;

public class ParseNumberException extends NumberFormatException {
    public ParseNumberException(String message) {
        super(message);
    }
}
