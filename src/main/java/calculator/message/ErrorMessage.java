package calculator.message;

public enum ErrorMessage {
    INPUT_NULL_OR_EMPTY("입력값이 없습니다."),
    INPUT_NOT_NUMBER("숫자가 아닌 값이 입력되었습니다."),
    INPUT_NOT_OPERATOR("연산자가 아닌 값이 입력되었습니다."),
    INPUT_NOT_OPERATOR_LENGTH("연산자가 빠졌거나 한글자만 입력해주세요."),
    INPUT_NUMBER_LENGTH("빈값이 존재합니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
