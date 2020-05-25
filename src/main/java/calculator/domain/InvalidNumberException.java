package calculator.domain;

public class InvalidNumberException extends RuntimeException {

    public InvalidNumberException(String message) {
        super(message);
    }
}
