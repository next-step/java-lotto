package lotto.common;

public enum ErrorCode {
    INVALID_LOTTO_NUMBER_RANGE("Lotto number should be from 1 to 45."),
    INVALID_LOTTO_NUMBER_LENGTH("Length of lotto number should be 6."),
    DUPLICATED_LOTTO_NUMBER("Winning number should not be duplicated."),
    INVALID_MONEY_RANGE("Money input should be bigger than lotto ticket price."),
    DUPLICATED_BONUS_NUMBER("Bonus ball should not be included in winning number.");

    private final String errorMessage;

    ErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
