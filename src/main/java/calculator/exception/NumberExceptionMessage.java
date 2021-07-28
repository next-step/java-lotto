package calculator.exception;

public enum NumberExceptionMessage {

    NUMBER_IS_EMPTY("숫자가 존재하지 않습니다"),
    NUMBER_IS_NEGATIVE("음수는 허용되지 않습니다"),
    NUMBER_IS_NON_NUMERIC("숫자가 아닙니다");

    private final String message;

    NumberExceptionMessage(String message) {
        this.message = message;
    }

    public String formatWithNumber(String number) {
        return String.format("%s: %s", message, number);
    }

}
