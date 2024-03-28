package lotto.error.exception;

import java.text.MessageFormat;

public class DuplicateLottoNumberException extends RuntimeException {

    public DuplicateLottoNumberException(Object parameter) {
        super(
            MessageFormat.format("{0} 입력값: {1}", "중복된 로또 번호가 존재합니다.",
                parameter));
    }
}
