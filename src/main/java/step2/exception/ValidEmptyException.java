package step2.exception;

public class ValidEmptyException extends  IllegalArgumentException {

    private static final String VALID_EMPTY_EXCEPTION = "빈값을 넣을수는 없습니다.";

    public ValidEmptyException() {
        super(VALID_EMPTY_EXCEPTION);
    }
}
