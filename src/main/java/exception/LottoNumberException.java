package exception;

public class LottoNumberException extends IllegalArgumentException {
    public LottoNumberException() {
        super(ExceptionMessage.INVALID_LOTTO_NUMBER_EXCEPTION_MESSAGE);
    }
}
