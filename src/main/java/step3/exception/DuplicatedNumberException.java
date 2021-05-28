package step3.exception;

public class DuplicatedNumberException extends RuntimeException {
    public static final String MESSAGE = "중복된 번호 입니다.";

    public DuplicatedNumberException() {
        super(MESSAGE);
    }
}
