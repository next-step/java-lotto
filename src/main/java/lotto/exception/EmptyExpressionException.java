package lotto.exception;

import java.text.MessageFormat;

public class EmptyExpressionException extends IllegalArgumentException {

    public EmptyExpressionException(String inputString) {
        super(MessageFormat.format("빈 문자열이 입력되었습니다. (입력값: {0})", inputString));
    }
}
