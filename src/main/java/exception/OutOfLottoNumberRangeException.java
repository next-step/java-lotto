package exception;

public class OutOfLottoNumberRangeException extends IllegalArgumentException {
    public static final String MESSAGE = "유효한 로또 숫자 범위가 아닙니다.";

    public OutOfLottoNumberRangeException() {
        super(MESSAGE);
    }
}
