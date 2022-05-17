package autolotto.exception;

public class LottoException extends RuntimeException {
    public LottoException(LottoExceptionCode lottoExceptionCode, String value) {
        this(lottoExceptionCode.getMessage(), value);
    }

    private LottoException(String errorMessage, String value) {
        super(errorMessage + " : " + value);
    }
}
