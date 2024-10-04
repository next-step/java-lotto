package step1.enums;

public enum ExceptionMessage {

    NULL_EMPTY_EXCEPTION("Null 이나 빈값이 포함되어있습니다."),
    SYMBOL_EXCEPTION("사칙연산 기호가 아닙니다. (+, -, *, /)");

    ExceptionMessage(String message) {
        this.message = message;
    }

    private final String message;

    public String message() {
        return message;
    }

}
