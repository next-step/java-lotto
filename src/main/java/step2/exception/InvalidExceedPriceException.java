package step2.exception;

public class InvalidExceedPriceException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "구매 금액보다 번호가 많습니다";

    public InvalidExceedPriceException() {
        super(ERROR_MESSAGE);
    }

}
