package lotto.exception;

public class NotNumberRangeException extends RuntimeException {
    private static final String MESSAGE = "로또 숫자는 1부터 45까지 입니다.";

    public NotNumberRangeException() {
        super(MESSAGE);
    }

}
