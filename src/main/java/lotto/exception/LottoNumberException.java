package lotto.exception;

public class LottoNumberException extends RuntimeException {
    private static final String MESSAGE = "로또 번호가 잘못 되었습니다.";


    public LottoNumberException() {
        super(MESSAGE);
    }
}
