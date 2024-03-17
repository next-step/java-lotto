package lotto.exception;

import java.text.MessageFormat;

public class IllegalEmptyExpressionException extends IllegalArgumentException {

    public IllegalEmptyExpressionException(String inputString) {
        super(MessageFormat.format("빈 문자열이 입력되었습니다. (입력값: {0})", inputString));
    }
}
