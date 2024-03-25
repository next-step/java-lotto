package lotto.error.exception;

import java.text.MessageFormat;
import lotto.error.ErrorMessage;

public class DuplicateLottoNumberException extends RuntimeException {

    public DuplicateLottoNumberException(Object parameter) {
        super(
            MessageFormat.format("{0} 입력값: {1}", ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage(),
                parameter));
    }
}
