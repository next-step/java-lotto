package exception;

public class LottoNumberDuplicatedException extends IllegalArgumentException {
    public LottoNumberDuplicatedException() {
        super(ExceptionMessage.DUPLICATED_LOTTO_NUMBER_EXCEPTION_MESSAGE);
    }
}
