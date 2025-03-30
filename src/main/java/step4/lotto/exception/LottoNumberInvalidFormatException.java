package step4.lotto.exception;

public class LottoNumberInvalidFormatException extends LottoNumberException{

    public static final String MESSAGE = "로또 번호는 숫자여야 합니다.";

    public LottoNumberInvalidFormatException() {
        super(MESSAGE);
    }

}
