package lotto.error.exception;

import java.text.MessageFormat;
import lotto.error.ErrorMessage;

public class SizeExceedLottoException extends RuntimeException{

    public SizeExceedLottoException(Object parameter) {
        super(MessageFormat.format("{0} 입력값: {1}", ErrorMessage.SIZE_EXCEED_LOTTO.getMessage(), parameter));
    }

}
