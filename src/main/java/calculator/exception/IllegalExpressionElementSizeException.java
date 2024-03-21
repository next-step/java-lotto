package calculator.exception;

import java.text.MessageFormat;

public class IllegalExpressionElementSizeException extends IllegalArgumentException {
    public IllegalExpressionElementSizeException(int size) {
        super(MessageFormat.format("수식 항의 개수가 홀수가 아닙니다. (입력된 항 개수: {0})", size));
    }
}
