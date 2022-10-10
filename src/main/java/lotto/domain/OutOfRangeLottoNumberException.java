package lotto.domain;

public class OutOfRangeLottoNumberException extends RuntimeException {

    private static final OutOfRangeLottoNumberException OUT_OF_RANGE_LOTTO_NUMBER_EXCEPTION =
            new OutOfRangeLottoNumberException("로또 숫자의 범위를 벗어난 숫자가 포함되어 있습니다. 유효한 로또 숫자 범위 : 1 ~ 45");

    private OutOfRangeLottoNumberException(String message) {
        super(message);
    }

    public static OutOfRangeLottoNumberException of() {
        return OUT_OF_RANGE_LOTTO_NUMBER_EXCEPTION;
    }
}
