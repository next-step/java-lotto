package config;

import java.text.MessageFormat;
import java.util.Arrays;

public enum CalculatorExceptionMessage {

    OPERAND_SHOULD_BE_INTEGER_FORMAT("피연산자는 반드시 정수형 숫자여야 합니다."),
    OPERATOR_SHOULD_BE_ARITHMETIC_SYMBOL("연산자는 반드시 사칙연산 기호(+, -, *, /) 중 하나여야 합니다."),
    DIVISOR_CANNOT_BE_ZERO("0으로 나눌 수 없습니다."),
    EXPRESSION_CANNOT_BE_NULL_OR_EMPTY("계산식은 null 이거나 비어있을 수 없습니다."),
    INPUT_EXPRESSION_TEXT_CANNOT_BE_NULL_OR_BLANK("계산식으로 null, 빈 문자열, 공백, 개행을 입력할 수 없습니다."),
    INPUT_EXPRESSION_TEXT_SHOULD_FOLLOW_PATTERN("형식에 맞는 계산식을 입력해야 합니다."),
    UNEXPECTED_EXCEPTION("알 수 없는 에러가 발생하였습니다."),
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

    public <T> String message(final T[] values) {
        return message(Arrays.toString(values));
    }
}
