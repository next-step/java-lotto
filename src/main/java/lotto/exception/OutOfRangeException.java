package lotto.exception;

public class OutOfRangeException extends RuntimeException {
    private final static String MESSAGE = "로또 번호는 6개로 되어있습니다.";

    public OutOfRangeException() {
        super(MESSAGE);
    }
}
