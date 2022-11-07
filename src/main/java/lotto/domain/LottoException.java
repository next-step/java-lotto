package lotto.domain;

public class LottoException extends IllegalArgumentException {

    private static final long serialVersionUID = -2804393084167244553L;

    private static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR]";

    public LottoException(final String message) {
        super(createExceptionMessage(message));
    }

    public LottoException(final String message, final Throwable cause) {
        super(createExceptionMessage(message), cause);
    }

    private static String createExceptionMessage(final String message) {
        return String.format("%s : %s", EXCEPTION_MESSAGE_PREFIX, message);
    }
}
