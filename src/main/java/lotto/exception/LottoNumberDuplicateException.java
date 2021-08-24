package lotto.exception;

public class LottoNumberDuplicateException extends RuntimeException {
    private static final String MESSAGE = "중복 로또 번호 만듬";

    public LottoNumberDuplicateException() {
        super(MESSAGE);
    }
}
