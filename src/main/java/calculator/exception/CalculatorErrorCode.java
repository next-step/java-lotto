package calculator.exception;

import exception.ErrorCode;

public enum CalculatorErrorCode implements ErrorCode {

    INPUT_VALUE_NULL_POINT_ERROR("값을 입력해주세요");

    private final String message;

    CalculatorErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
