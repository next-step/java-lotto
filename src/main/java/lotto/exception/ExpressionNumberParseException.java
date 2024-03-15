package lotto.exception;

import java.text.MessageFormat;

public class ExpressionNumberParseException extends NumberFormatException {

    public ExpressionNumberParseException(String number) {
        super(MessageFormat.format("숫자 형식이 아닙니다. (입력된 숫자: {0})", number));
    }

}
