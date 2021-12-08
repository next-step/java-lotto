package step2.exception;

public class DuplicatedNumberException extends IllegalArgumentException {
    private static final String DUPLICATED_NUMBER = "중복되지 않은 숫자여야합니다.";

    public DuplicatedNumberException() {
        super(DUPLICATED_NUMBER);
    }
}
