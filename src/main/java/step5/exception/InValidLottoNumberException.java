package step5.exception;

public class InValidLottoNumberException extends RuntimeException {

    public static final String MESSAGE = "유효 하지 않은 로또 번호 입니다.";

    public InValidLottoNumberException() {
        super(MESSAGE);
    }
}
