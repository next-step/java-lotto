package study.lotto.exception;

public class LottoException extends RuntimeException {
    public LottoException() { }
    public LottoException(final String message) {
        super(message);
    }
}
