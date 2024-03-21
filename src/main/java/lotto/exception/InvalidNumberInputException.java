package lotto.exception;

public class InvalidNumberInputException extends IllegalArgumentException{
    public InvalidNumberInputException() {
        super("숫자만 입력 가능합니다.");
    }
}
