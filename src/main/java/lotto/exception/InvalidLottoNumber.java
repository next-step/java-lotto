package lotto.exception;

public class InvalidLottoNumber extends RuntimeException {
    public static String INVALID_LOTTO_NUMBER = "INVALID LOTTO NUMBER";
    public static String MESSAGE_DELIMITER = ":";
    public InvalidLottoNumber() {
        super(INVALID_LOTTO_NUMBER);
    }

    public InvalidLottoNumber(String message) {
        super(String.join(MESSAGE_DELIMITER,INVALID_LOTTO_NUMBER,message));
    }
}
