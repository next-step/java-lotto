package calculator.domain.exception;

public class UnexpectedOperatorException extends RuntimeException {

    public UnexpectedOperatorException() {
        super("연산을 지원하지 않는 문자열입니다.");
    }

}
