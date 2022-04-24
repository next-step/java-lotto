package lotto.exception;

public class InvalidLottoException extends RuntimeException{

    public static final String INVALID_LOTTO_ERROR_MESSAGE = "로또 숫자의 갯수는 6개여야 합니다.";

    public InvalidLottoException() {
        super(INVALID_LOTTO_ERROR_MESSAGE);
    }
}
