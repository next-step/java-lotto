package calculator.exception;

import calculator.type.ExceptionType;

public class CalculatorException extends RuntimeException{
    private ExceptionType type;

    public CalculatorException(ExceptionType type) {
        super(type.getMessage());

        this.type = type;
    }
}
