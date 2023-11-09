package step1.exception;

public class InvalidRegexException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "잘못된 입력 값입니다";

    public InvalidRegexException() {
        super(ERROR_MESSAGE);
    }

}
