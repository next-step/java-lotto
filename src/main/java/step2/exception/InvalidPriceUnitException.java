package step2.exception;

public class InvalidPriceUnitException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "구매 금액은 1000원 단위여야합니다";

    public InvalidPriceUnitException() {
        super(ERROR_MESSAGE);
    }

}
