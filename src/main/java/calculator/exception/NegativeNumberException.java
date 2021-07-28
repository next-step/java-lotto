package calculator.exception;

public class NegativeNumberException extends RuntimeException {

    public NegativeNumberException(String number) {
        super(NumberExceptionMessage.NUMBER_IS_NEGATIVE.formatWithNumber(number));
    }
}
