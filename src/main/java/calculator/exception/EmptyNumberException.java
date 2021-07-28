package calculator.exception;

public class EmptyNumberException extends RuntimeException {

    public EmptyNumberException(String number) {
        super(NumberExceptionMessage.NUMBER_IS_EMPTY.formatWithNumber(number));
    }
}
