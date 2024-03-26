package stringCalculator.error.exception;

import java.text.MessageFormat;

public class WhiteSpaceMissingException extends RuntimeException {

    public WhiteSpaceMissingException(Object input) {
        super(MessageFormat.format("{0}, 입력값 : {1}", "입력값은 한 칸씩 띄어져 있어야 합니다", input));
    }
}
