package calculator.exception;

public class NonNumericNumberException extends RuntimeException {

    public NonNumericNumberException(String number) {
        super(NumberExceptionMessage.NUMBER_IS_NON_NUMERIC.formatWithNumber(number));
    }
}
