package stringcalculator.exception;

public class NoSupportedSplitterException extends RuntimeException {

    private static final String ERROR_MESSAGE = "지원하는 구분자가 없습니다.";

    public NoSupportedSplitterException() {
        super(ERROR_MESSAGE);
    }
}
