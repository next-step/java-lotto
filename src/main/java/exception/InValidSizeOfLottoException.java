package exception;

public class InValidSizeOfLottoException extends IllegalArgumentException {
    public static final String MESSAGE = "로또 숫자는 6개 이어야 합니다.";

    public InValidSizeOfLottoException() {
        super(MESSAGE);
    }
}
