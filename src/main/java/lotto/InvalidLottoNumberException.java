package lotto;

public class InvalidLottoNumberException extends RuntimeException {

    public static final String INVALID_LOTTO_NUMBER_ERROR_MESSAGE = "로또 숫자는 1 에서 45까지 가능합니다.";

    public InvalidLottoNumberException() {
        super(INVALID_LOTTO_NUMBER_ERROR_MESSAGE);
    }
}
