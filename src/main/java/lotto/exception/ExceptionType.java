package lotto.exception;

import lombok.Getter;

public enum ExceptionType {
    INVALID_LOTTO_NUMBER_SIZE("Lotto number must be 6"),
    INVALID_LOTTO_NUMBER("invalid Lotto number"),
    DUPLICATED_LOTTO_NUMBER("Lotto Number Duplicated"),
    DUPLICATED_LOTTO_BONUS_NUMBER("Bonus Number Duplicated"),
    NOT_ENOUGH_MONEY("not enough money");

    @Getter
    private String message;

    ExceptionType(String message) {
        this.message = message;
    }
}
