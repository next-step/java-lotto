package calculator.exception;

public class DivisionResultFloatException extends RuntimeException {
    public DivisionResultFloatException() {
        super("나눗셈은 결과가 정수가 아닙니다.");
    }
}
