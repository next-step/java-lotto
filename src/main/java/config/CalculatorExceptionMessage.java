package config;

import java.text.MessageFormat;

public enum CalculatorExceptionMessage {

    OPERAND_SHOULD_BE_INTEGER_FORMAT("피연산자가 정수형 숫자가 아닙니다.");

    private final String message;

    CalculatorExceptionMessage(final String message) {
        this.message = message;
    }

    public <T> String message(final T value) {
        return MessageFormat.format("{0} [값 : {1}]", this.message, value);
    }
}
