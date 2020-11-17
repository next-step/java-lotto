package exception;

public class LottoPriceException extends IllegalArgumentException {
    LottoPriceException() {
        super(ExceptionMessage.LESS_THEN_1_EXCEPTION_MESSAGE);
    }
}
