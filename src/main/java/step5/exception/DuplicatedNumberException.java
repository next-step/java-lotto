package step5.exception;

public class DuplicatedNumberException extends RuntimeException {
    public static final String DUPLICATED_MESSAGE = "중복된 번호 입니다.";

    public DuplicatedNumberException() {
        super(DUPLICATED_MESSAGE);
    }
}
