package lotto.error;

import java.text.MessageFormat;

public class SizeExceedLottoException extends RuntimeException{

    public SizeExceedLottoException(Object parameter) {
        super(MessageFormat.format("{0} 입력값: {1}", ErrorMessage.SIZE_EXCEED_LOTTO.getMessage(), parameter));
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
