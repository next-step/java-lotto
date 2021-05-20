package stringCalculator.common;

public enum ErrorMessage {
    NEGATIVE_VALUE("음수 값을 생성 할 수 없습니다.");

    String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public void throwError() {
        throw new RuntimeException(message);
    }
}