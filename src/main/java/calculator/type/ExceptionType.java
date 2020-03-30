package calculator.type;

import lombok.Getter;

public enum ExceptionType {
    INVALID_NUMBER("Cannot be less than 0");

    @Getter
    private String message;

    ExceptionType(String message) {
        this.message = message;
    }
}
