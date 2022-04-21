package StringCalculator;

public enum ExceptionMessage {
    INPUT_SHOULD_NOT_NULL_OR_BLANK("Input은 null 또는 공백은 안됩니다. 다시 입력해주세요.");

    ExceptionMessage(String message) {
        this.message = message;
    }

    private final String message;

    public String getMessage() {
        return message;
    }
}
