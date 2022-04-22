package stringcalculator.exception;

public class BlankInputException extends RuntimeException {

    private static final String EMPTY_OR_NULL_ERROR_MESSAGE = "문자열을 입력해야 합니다.";

    public BlankInputException() {
        super(EMPTY_OR_NULL_ERROR_MESSAGE);
    }
}
