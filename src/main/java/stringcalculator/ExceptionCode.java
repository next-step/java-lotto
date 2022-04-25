package stringcalculator;

public enum ExceptionCode {
    INPUT_SHOULD_NOT_NULL_OR_BLANK("Input은 null 또는 공백은 안됩니다. 다시 입력해주세요."),
    WHITESPACE_REQUIRED_BETWEEN_CHARACTER("숫자와 사칙연산 사이에는 공백이 있어야 합니다. ex) 1 + 2"),
    DIVIDE_RESULT_SHOULD_BE_INTEGER("계산 중 나눗셈의 결과가 정수가 아닙니다."),
    NUMBER_SHOULD_NOT_BE_ZERO_WHEN_DIVIDING("나눗셈 대상 숫자는 0이 아닌 경우만 가능합니다.");

    ExceptionCode(String message) {
        this.message = message;
    }

    private final String message;

    public String getMessage() {
        return message;
    }
}
