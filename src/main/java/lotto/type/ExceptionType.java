package lotto.type;

import lombok.Getter;

public enum ExceptionType {
    INVALID_LOTTO_NUMBER("Lotto number must be 6");

    @Getter
    private String message;

    ExceptionType(String message) {
        this.message = message;
    }
}
