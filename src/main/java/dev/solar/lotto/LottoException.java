package dev.solar.lotto;

public class LottoException extends RuntimeException {
    public LottoException(final String message) {
        super(message);
    }

    public LottoException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
