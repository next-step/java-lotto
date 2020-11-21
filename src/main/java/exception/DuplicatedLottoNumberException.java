package exception;

public class DuplicatedLottoNumberException extends IllegalArgumentException {
    public static final String MESSAGE = "중복된 로또 숫자가 존재합니다.";
    public DuplicatedLottoNumberException() {
        super(MESSAGE);
    }
}
