package calculator.exception;

public enum ExceptionMessage {

    ERROR_EMPTY_OPERATOR("부호가 누락되었습니다."),
    ERROR_INVALID_OPERATOR("잘못된 부호입니다."),
    ERROR_DIVIDE_ZERO("0은 나눗셈의 피연산자로 사용될 수 없습니다."),
    ERROR_INVALID_VALUE_TO_DIVIDE("결과 값이 정수로 떨어지는 값만 계산 가능합니다."),
    ERROR_NEGATIVE_VALUE("0 미만의 숫자는 허용되지 않습니다."),
    ERROR_EMPTY_VALUE("입력 값이 누락되었습니다."),
    ERROR_INVALID_VALUE_TO_CONVERT("변환할 수 없는 문자가 포함되어 있습니다."),
    ERROR_INVALID_VALUE_CALCULATE("계산할 수 없는 식입니다.");

    private final String message;

    ExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
