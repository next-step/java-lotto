package lotto.exception;

public class NegativePriceException extends RuntimeException {
    private static final String EXCEPTION_MESSAGE = "금액은 마이너스가 될 수 없습니다.";

    public NegativePriceException() {
        super(EXCEPTION_MESSAGE);
    }
}
