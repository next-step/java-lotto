package lotto.exception;

public class NoPurchasePriceException extends RuntimeException {
    private static final String EXCEPTION_MESSAGE = "로또 구매 가능한 금액은 천원 이상 입니다. : %d";

    public NoPurchasePriceException(final int causativeValue) {
        super(String.format(EXCEPTION_MESSAGE, causativeValue));
    }
}
