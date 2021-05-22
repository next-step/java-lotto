package calculator;

public class AllowedOnlyPositiveNumberException extends RuntimeException {
    public AllowedOnlyPositiveNumberException() {
        super(Constants.ALLOWED_POSITIVE_ONLY_EXCEPTION_MESSAGE);
    }
}
