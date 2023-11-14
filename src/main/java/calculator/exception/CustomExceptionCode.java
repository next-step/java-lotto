package calculator.exception;

public enum CustomExceptionCode {
    NULL_OR_BLANK_INPUT("입력 값이 없습니다. 입력 값을 확인해주세요."),
    NOT_FOUR_BASIC_OPERATIONS("사칙연산 기호가 아닙니다."),
    INCOMPLETED_FORMULA("계산식이 완성되지 않았습니다.");

    private String message;

    CustomExceptionCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
