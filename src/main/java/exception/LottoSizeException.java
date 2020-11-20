package exception;

public class LottoSizeException extends IllegalArgumentException {
    public LottoSizeException() {
        super(ExceptionMessage.LOTTO_SIZE_EXCEPTION_MESSAGE);
    }
}
