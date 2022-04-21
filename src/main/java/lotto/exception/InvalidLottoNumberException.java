package lotto.exception;

public class InvalidLottoNumberException extends RuntimeException {

    private static final String INVALID_LOTTO_NUMBER_MESSAGE_FORMAT = "올바르지 않는 로또 번호 입니다 : %d";

    public InvalidLottoNumberException(int number) {
        super(String.format(INVALID_LOTTO_NUMBER_MESSAGE_FORMAT, number));
    }

}
