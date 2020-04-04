package lotto.exception;

public class ManualSizeOverflowException extends RuntimeException {
    private static final String EXCEPTION_MESSAGE = "구입 금액보다 수동 로또 번호를 많이 입력하셨습니다. : %d";

    public ManualSizeOverflowException(final int causativeValue) {
        super(String.format(EXCEPTION_MESSAGE, causativeValue));
    }
}
