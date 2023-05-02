package lotto.domain.exception;

public class InvalidLottoSizeException extends LottoException {
    private static final String INVALID_LOTTO_SIZE_MESSAGE = "로또는 6개의 숫자로 구성됩니다.";

    public InvalidLottoSizeException(String... message) {
        super(INVALID_LOTTO_SIZE_MESSAGE, message);
    }
}
