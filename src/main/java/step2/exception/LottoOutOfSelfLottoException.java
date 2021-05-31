package step2.exception;

public class LottoOutOfSelfLottoException extends RuntimeException {
    private static final String ERROR_MSG = "금액 대비 수동구입 개수가 많습니다.";

    public LottoOutOfSelfLottoException() {
        super(ERROR_MSG);
    }
}