package calculator.exception;

public class ParsingOperatorFailureException extends RuntimeException {

    public ParsingOperatorFailureException() {
        this("지원하지 않는 연산자입니다.");
    }

    public ParsingOperatorFailureException(String message) {
        super(message);
    }
}
