package stringcalculator.common;

public enum ExceptionMessage {
    WRONG_EXPRESSION("입력한 수식이 잘못됐습니다."),
    WRONG_NUMBER("입력한 숫자가 잘못됐습니다.")
    ;

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String printMessage() {
        return this.message;
    }
}
