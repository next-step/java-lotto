package lotto.domain;

public class InvalidLottoNumbersSizeException extends RuntimeException {

    private static final InvalidLottoNumbersSizeException INVALID_LOTTO_NUMBERS_SIZE_EXCEPTION =
            new InvalidLottoNumbersSizeException("올바르지 않은 로또 숫자 개수 입니다. 유효한 로또 숫자 개수 : 6");

    private InvalidLottoNumbersSizeException(String message) {
        super(message);
    }

    public static InvalidLottoNumbersSizeException of() {
        return INVALID_LOTTO_NUMBERS_SIZE_EXCEPTION;
    }
}
