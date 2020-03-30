package lotto.exception;

public class InvalidLottoNumberException extends RuntimeException {
    private static final String EXCEPTION_MESSAGE = "1 ~ 45 사이의 숫자가 아닙니다. : %d";

    public InvalidLottoNumberException(final int causativeValue) {
        super(String.format(EXCEPTION_MESSAGE, causativeValue));
    }
}
