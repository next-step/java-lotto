package step4.lotto.exception;

public class CountInvalidFormatException extends CountException{

    public static final String MESSAGE = "카운트는 숫자여야 합니다.";

    public CountInvalidFormatException() {
        super(MESSAGE);
    }

}
