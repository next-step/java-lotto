package lotto.domain.exception;

public final class AmountLowException extends IllegalArgumentException {

    private static final String BELOW_MIN_AMOUNT_ERROR_MESSAGE = "최소 1000원 이상 지불하셔야 합니다.";

    public AmountLowException() {
        super(BELOW_MIN_AMOUNT_ERROR_MESSAGE);
    }

}
