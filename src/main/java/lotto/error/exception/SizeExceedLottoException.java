package lotto.error.exception;

import java.text.MessageFormat;
import lotto.error.ErrorMessage;

public class SizeExceedLottoException extends RuntimeException {

    public SizeExceedLottoException(Object parameter) {
        super(MessageFormat.format("{0} 입력값: {1}", "로또의 사이즈는 최대 6입니다.",
            parameter));
    }

}
