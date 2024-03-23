package lotto.error;

import java.text.MessageFormat;

public class SizeExceedLottoNumberException extends RuntimeException{

    public SizeExceedLottoNumberException(Object parameter) {
        super(MessageFormat.format("{0} 입력값: {1}", ErrorMessage.SIZE_EXCEED_LOTTO_NUMBER.getMessage(), parameter));
    }
}
