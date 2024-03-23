package lotto.common;

public enum MessageSet {
    NOT_ENOUGH_MONEY("금액이 부족합니다.");

    private final String errorMessage;

    MessageSet(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
