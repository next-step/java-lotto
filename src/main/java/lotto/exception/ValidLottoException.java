package lotto.exception;

public class ValidLottoException extends RuntimeException {

    private static final String FORMAT = "로또생성 실패 : %s";

    public ValidLottoException(String message) {
        super(String.format(FORMAT, message));
    }
}
