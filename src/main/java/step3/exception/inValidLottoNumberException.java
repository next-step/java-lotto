package step3.exception;

public class inValidLottoNumberException extends RuntimeException {

    public static final String MESSAGE = "유효 하지 않은 로또 번호 입니다.";

    public inValidLottoNumberException() {
        super(MESSAGE);
    }
}
