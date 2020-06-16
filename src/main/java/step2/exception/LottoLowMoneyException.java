package step2.exception;

public class LottoLowMoneyException extends RuntimeException {
    private static final String ERROR_MSG = "금액은 1000원 이상이여야 합니다.";

    public LottoLowMoneyException() {
        super(ERROR_MSG);
    }
}
