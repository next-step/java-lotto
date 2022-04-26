package autolotto;

public class LottoException extends RuntimeException {

    private final LottoExceptionCode lottoExceptionCode;
    private final String errorMessage;

    public LottoException(LottoExceptionCode lottoExceptionCode) {
        this(lottoExceptionCode, lottoExceptionCode.getMessage());
    }

    public LottoException(LottoExceptionCode lottoExceptionCode, String errorMessage) {
        super(errorMessage);
        this.lottoExceptionCode = lottoExceptionCode;
        this.errorMessage = errorMessage;
    }
}
