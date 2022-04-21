package StringCalculator;

public enum ExceptionMessage {
    INPUT_SHOULD_NOT_NULL_OR_BLANK("Input은 null 또는 공백은 안됩니다. 다시 입력해주세요."),
    WHITESPACE_REQUIRED_BETWEEN_CHARACTER("숫자와 사칙연산 사이에는 공백이 있어야 합니다. ex) 1 + 2");

    ExceptionMessage(String message) {
        this.message = message;
    }

    private final String message;

    public String getMessage() {
        return message;
    }
}
