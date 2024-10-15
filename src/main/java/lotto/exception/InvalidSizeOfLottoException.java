package lotto.exception;

public class InvalidSizeOfLottoException extends RuntimeException {

    private static final String INVALID_SIZE_OF_LOTTO_EXCEPTION_MESSAGE = "로또 번호 갯수 오류입니다.";

    public InvalidSizeOfLottoException() {
        super(INVALID_SIZE_OF_LOTTO_EXCEPTION_MESSAGE);
    }
}
