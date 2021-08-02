package calculator.exception;

public class NotNaturalNumberException extends RuntimeException{
    public NotNaturalNumberException() {
        super("Not a natural number.");
    }
}
