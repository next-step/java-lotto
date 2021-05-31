package lotto.exception;

public class WrongNumberException extends RuntimeException{
    public static final String WRONG_INPUT_NUMBER = "번호를 잘 못 입력하셨습니다.";

    public WrongNumberException() {
        super(WRONG_INPUT_NUMBER);
    }

    public WrongNumberException(String message) {
        super(message);
    }
}


