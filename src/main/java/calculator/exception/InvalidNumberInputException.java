package calculator.exception;

public class InvalidNumberInputException extends RuntimeException {

    public InvalidNumberInputException() {
        super("null, 공백 문자열로 객체를 생성할 수 없습니다.");
    }

}
