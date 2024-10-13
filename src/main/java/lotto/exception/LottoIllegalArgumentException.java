package lotto.exception;

public class LottoIllegalArgumentException extends RuntimeException {
    public static final LottoIllegalArgumentException INVALID_PARSE_TO_INT = new LottoIllegalArgumentException("숫자로 변환할 수 없는 입력 값입니다.");
    public static final LottoIllegalArgumentException INVALID_MANUAL_LOTTO_COUNT = new LottoIllegalArgumentException("금액이 부족하여 수동 로또 개수를 원하는 수 만큼 구매할 수 없습니다.");

    private LottoIllegalArgumentException(String errorMessage) {
        super(errorMessage);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
