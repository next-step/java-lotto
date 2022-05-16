package lotto.exceptions;

public class InvalidLottoNumberException extends IllegalArgumentException {
    public static final String INVALID_LOTTO_NUMBER = "1에서 45사이의 숫자만 입력 가능합니다.";

    public InvalidLottoNumberException() {
        super(INVALID_LOTTO_NUMBER);
    }
}
