package step4.lotto.exception;

public class LottoNumberInvalidValueException extends LottoNumberException {

    public static final String MESSAGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public LottoNumberInvalidValueException() {
        super(MESSAGE);
    }

}
