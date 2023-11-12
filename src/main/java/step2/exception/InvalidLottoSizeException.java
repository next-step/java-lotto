package step2.exception;

public class InvalidLottoSizeException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "로또 숫자 개수가 유효하지 않습니다";

    public InvalidLottoSizeException() {
        super(ERROR_MESSAGE);
    }

}
