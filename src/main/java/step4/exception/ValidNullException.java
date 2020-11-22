package step4.exception;

public class ValidNullException extends  IllegalArgumentException{
    private static final String VALID_NULL_EXCEPTION = "널값을 넣을수는 없습니다.";

    public ValidNullException() {
        super(VALID_NULL_EXCEPTION);
    }
}
