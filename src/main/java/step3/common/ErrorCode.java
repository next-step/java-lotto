package step3.common;

public enum ErrorCode {
    INVALID_LOTTO_NUMBER_RANGE("Lotto number should be from 1 to 45."),
    INVALID_LOTTO_NUMEBRS_LENGTH("Length of lotto number should be 6.");

    private final String errorMessage;

    ErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
