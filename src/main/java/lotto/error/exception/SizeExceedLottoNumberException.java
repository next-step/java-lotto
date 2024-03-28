package lotto.error.exception;

import java.text.MessageFormat;

public class SizeExceedLottoNumberException extends RuntimeException {

    public SizeExceedLottoNumberException(Object parameter) {
        super(
            MessageFormat.format("{0} 입력값: {1}", "로또 번호는 1부터 45의 범위만 가능합니다.",
                parameter));
    }
}
