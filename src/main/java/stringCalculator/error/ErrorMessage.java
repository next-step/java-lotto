package stringCalculator.error;

public enum ErrorMessage {

    DIVIDE_VALUE_ERROR("나눗셈의 결과는 정수여야 합니다"),

    INPUT_VALUE_NOT_NULL_AND_BLANK("입력값은 NULL 또는 빈 문자열일수 없습니다"),

    INPUT_VALUE_NUMBER_AND_OPERATOR("입력값은 숫자 또는 연산자로 이뤄져야 합니다"),

    INPUT_VALUE_VALID_BLANK_SPACE("입력값은 한 칸씩 띄어져 있어야 합니다 "),

    INPUT_VALUE_NOT_OPERATOR("입력값은 한 칸씩 띄어져 있어야 합니다 ");

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }
}
