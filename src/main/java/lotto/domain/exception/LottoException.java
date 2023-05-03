package lotto.domain.exception;

import lotto.util.StringConcatenater;

public class LottoException extends IllegalArgumentException {
    public LottoException(String message, String[] messages) {
        super(StringConcatenater.concatStrings(message, messages));
    }

    public LottoException(Throwable cause, String message, String... messages) {
        super(StringConcatenater.concatStrings(message, messages), cause);
    }
}
