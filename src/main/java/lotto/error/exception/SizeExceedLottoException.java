package lotto.error.exception;

import java.text.MessageFormat;

public class SizeExceedLottoException extends RuntimeException {

    public SizeExceedLottoException(Object parameter) {
        super(MessageFormat.format("{0} 입력값: {1}", "로또 개수는 6개여야 합니다.",
            parameter));
    }

}
