package calculator;

public enum ErrorMessage {
    DIVISION_BY_ZERO("0으로 나눌 수 없습니다"),
    INVALID_OPERATOR("잘못된 연산기호 입니다"),
    NULL_OR_EMPTY_STRING("null 혹은 공백 문자열은 연산 불가능합니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
