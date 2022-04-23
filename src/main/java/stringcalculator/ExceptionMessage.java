package stringcalculator;

public enum ExceptionMessage {
    INPUT_SHOULD_NOT_NULL_OR_BLANK("Input은 null 또는 공백은 안됩니다. 다시 입력해주세요."),
    WHITESPACE_REQUIRED_BETWEEN_CHARACTER("숫자와 사칙연산 사이에는 공백이 있어야 합니다. ex) 1 + 2"),
    DIVIDE_RESULT_SHOULD_BE_INTEGER("계산 중 나눗셈의 결과가 정수가 아닙니다.");

    ExceptionMessage(String message) {
        this.message = message;
    }

    private final String message;

    public String getMessage() {
        return message;
    }
}
