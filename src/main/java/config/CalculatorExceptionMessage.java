package config;

import java.text.MessageFormat;

public enum CalculatorExceptionMessage {

    OPERAND_SHOULD_BE_INTEGER_FORMAT("피연산자는 반드시 정수형 숫자여야 합니다."),
    OPERATOR_SHOULD_BE_ARITHMETIC_SYMBOL("연산자는 반드시 사칙연산 기호(+, -, *, /) 중 하나여야 합니다."),
    DIVISOR_CANNOT_BE_ZERO("0으로 나눌 수 없습니다."),
    ;

    private final String message;

    CalculatorExceptionMessage(final String message) {
        this.message = message;
    }

    public String message() {
        return this.message;
    }

    public <T> String message(final T value) {
        return MessageFormat.format("{0} [값 : {1}]", this.message, value);
    }
}
