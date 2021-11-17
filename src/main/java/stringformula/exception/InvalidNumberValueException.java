package stringformula.exception;

public class InvalidNumberValueException extends RuntimeException {
    public InvalidNumberValueException() {
        super("피연산자가 올바르지 않습니다.");
    }
}
