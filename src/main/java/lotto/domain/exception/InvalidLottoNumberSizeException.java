package lotto.domain.exception;

public class InvalidLottoNumberSizeException extends LottoDomainException {

    private static final InvalidLottoNumberSizeException INVALID_LOTTO_NUMBER_SIZE_EXCEPTION =
            new InvalidLottoNumberSizeException("올바르지 않은 로또 숫자 개수 입니다. 올바른 숫자 개수(중복제외) : 6");

    private InvalidLottoNumberSizeException(String message) {
        super(message);
    }

    public static InvalidLottoNumberSizeException getInstance() {
        return INVALID_LOTTO_NUMBER_SIZE_EXCEPTION;
    }
}
