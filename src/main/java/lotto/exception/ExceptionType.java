package lotto.exception;

import lombok.Getter;

public enum ExceptionType {
    INVALID_LOTTO_NUMBER("Lotto number must be 6"),
    DUPLICATED_LOTTO_NUMBER("Lotto Number Duplicated");

    @Getter
    private String message;

    ExceptionType(String message) {
        this.message = message;
    }
}
