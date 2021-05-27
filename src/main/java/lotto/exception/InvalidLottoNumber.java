package lotto.exception;

public class InvalidLottoNumber extends RuntimeException {
    public static String INVALID_LOTTO_NUMBER = "INVALID LOTTO NUMBER";

    public InvalidLottoNumber() {
        super(INVALID_LOTTO_NUMBER);
    }

    public InvalidLottoNumber(String message) {
        super(message);
    }
}
