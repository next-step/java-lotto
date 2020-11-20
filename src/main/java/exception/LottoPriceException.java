package exception;

public class LottoPriceException extends IllegalArgumentException {
    public LottoPriceException() {
        super(ExceptionMessage.LESS_THEN_1_EXCEPTION_MESSAGE);
    }
}
