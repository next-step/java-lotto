package stringcalculator;

public class CaculateException extends RuntimeException {
    private final ErrorCode errorCode;

    public CaculateException(ErrorCode errorCode) {
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode;
    }
}
