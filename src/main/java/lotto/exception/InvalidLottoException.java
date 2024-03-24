package lotto.exception;

public class InvalidLottoException extends IllegalArgumentException {
    private static final String WRONG_LOTTO_NUMBERS_SIZE_MESSAGE = "(size: %d): 잘못된 로또 번호 크기입니다.";

    public InvalidLottoException(int wrongSize) {
        super(String.format(WRONG_LOTTO_NUMBERS_SIZE_MESSAGE, wrongSize));
    }
}
