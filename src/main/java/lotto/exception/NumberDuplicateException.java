package lotto.exception;

public class NumberDuplicateException extends RuntimeException {
    private final static String MESSAGE = "중복된 숫자는 입력할 수 없습니다.";

    public NumberDuplicateException() {
        super(MESSAGE);
    }
}
