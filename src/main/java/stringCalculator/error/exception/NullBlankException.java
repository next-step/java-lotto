package stringCalculator.error.exception;

import java.text.MessageFormat;

public class NullBlankException extends RuntimeException {

    public NullBlankException(Object input) {
        super(MessageFormat.format("{0}, 입력값 : {1}", "입력값은 NULL 또는 빈 문자열일수 없습니다", input));
    }
}
