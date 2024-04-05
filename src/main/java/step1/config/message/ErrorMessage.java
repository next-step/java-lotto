package step1.config.message;

import java.text.MessageFormat;
import java.util.Arrays;

public enum ErrorMessage {
    OPERATOR_VALIDATION("'+,-,*,/'이외의 연산자는 사용할 수 없습니다."),
    NULL_OR_EMPTY_VALIDATION("문자열이 빈값 이거나 null일 수 없습니다."),
    DIVIDE_BY_ZERO_NOT_ALLOWED("0으로 나눌 수 없습니다.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String message() {
        return this.message;
    }

    public <T> String message(final T value) {
        return MessageFormat.format("{0} value : {1} ", this.message, value);
    }
}
