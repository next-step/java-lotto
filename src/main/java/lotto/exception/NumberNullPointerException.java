package lotto.exception;

public class NumberNullPointerException extends NullPointerException {

    private static final String MESSAGE = "숫자는 NULL일 수 없습니다.";

    public NumberNullPointerException() {
        super(MESSAGE);
    }

}
