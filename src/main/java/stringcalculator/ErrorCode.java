package stringcalculator;

public enum ErrorCode {
    WRONG_OPERATOR("잘못된 연산자 입니다."),
    NUMBER_IS_NULL("숫자는 빈 값일 수 없습니다."),
    WRONG_NUMBER_FORMAT("잘못된 숫자 형식 입니다."),
    DIVIDE_WITH_ZERO("0으로 나눌 수 없습니다."),
    EXIST_REMAINDER("나눗셈 결과가 정수로 나누어 떨어지지 않습니다."),
    CALCULATE_NULL("공백이나 null은 계산할 수 없습니다."),
    WRONG_EQUATION_FORMAT("공백이나 null은 계산할 수 없습니다.");

    private final String errorMessage;

    ErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
