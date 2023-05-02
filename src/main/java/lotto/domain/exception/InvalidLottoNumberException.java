package lotto.domain.exception;

public class InvalidLottoNumberException extends LottoException {
    private static final String INVALID_LOTTO_NUMBER_MESSAGE = "로또는 1~45 사이의 숫자로 구성됩니다.";

    public InvalidLottoNumberException(String... messages) {
        super(INVALID_LOTTO_NUMBER_MESSAGE, messages);
    }
}
