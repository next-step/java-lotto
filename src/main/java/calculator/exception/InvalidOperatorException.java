package calculator.exception;

public class InvalidOperatorException extends IllegalArgumentException {

    public InvalidOperatorException() {
        super("사칙연산자아 아닌 연산자가 존재합니다.");
    }

}
