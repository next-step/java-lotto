package calculator.exception;

public class UnexpectedCharacterException extends RuntimeException {

    public UnexpectedCharacterException() {
        super("숫자가 아닌 문자열로 객체를 생성할 수 없습니다.");
    }

}
