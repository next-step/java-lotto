package step2.exception;

public class LottoLowMoneyException extends RuntimeException {

    private static final String ERROR_MSG = "최소 구매금액은 1000원 입니다.";

    public LottoLowMoneyException() {
        super(ERROR_MSG);
    }
}
