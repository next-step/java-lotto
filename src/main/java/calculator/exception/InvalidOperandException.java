package calculator.exception;

public class InvalidOperandException extends IllegalArgumentException {

    public InvalidOperandException() {
        super("숫자가 아닌 피연산자가 존재합니다.");
    }

}
