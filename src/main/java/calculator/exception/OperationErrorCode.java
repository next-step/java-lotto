package calculator.exception;

import exception.ErrorCode;

public enum OperationErrorCode implements ErrorCode {

    NOT_OPERATION_SYMBOL("사칙연산 기호가 아닙니다");

    private final String message;

    OperationErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
