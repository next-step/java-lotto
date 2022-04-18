package lotto.exception;

public class InvalidLottoNumberException extends RuntimeException {

    private static final String INVALID_LOTTO_NUMBER_MESSAGE = "올바르지 않는 로또 번호 입니다";

    public InvalidLottoNumberException() {
        super(INVALID_LOTTO_NUMBER_MESSAGE);
    }

}
