package lotto.domain;

public class InvalidLottoNumberSizeException extends RuntimeException {

    private static final InvalidLottoNumberSizeException INVALID_LOTTO_NUMBER_SIZE_EXCEPTION =
            new InvalidLottoNumberSizeException("올바르지 않은 로또 숫자 개수 입니다. 유효한 로또 숫자 개수 : 6");

    private InvalidLottoNumberSizeException(String message) {
        super(message);
    }

    public static InvalidLottoNumberSizeException of() {
        return INVALID_LOTTO_NUMBER_SIZE_EXCEPTION;
    }
}
