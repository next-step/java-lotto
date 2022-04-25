package stringcalculator;

public class CalculatorException extends RuntimeException{

    private final ExceptionCode exceptionCode;
    private final String errorMessage;

    public CalculatorException(ExceptionCode exceptionCode) {
        this(exceptionCode, exceptionCode.getMessage());
    }

    public CalculatorException(ExceptionCode exceptionCode, String errorMessage) {
        super(errorMessage);
        this.exceptionCode = exceptionCode;
        this.errorMessage = errorMessage;
    }
}
