package lotto.exception;

public class PrizeOverFlowIsNegativeException extends IllegalArgumentException {
    public static final String ERROR_MESSAGE = "당첨금 계산 중 오버플로 발생";

    public PrizeOverFlowIsNegativeException() {
        super(ERROR_MESSAGE);
    }

}
