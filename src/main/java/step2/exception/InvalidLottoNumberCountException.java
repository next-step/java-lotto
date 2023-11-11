package step2.exception;

public class InvalidLottoNumberCountException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "로또 숫자가 유효하지 않습니다";

    public InvalidLottoNumberCountException() {
        super(ERROR_MESSAGE);
    }

}
