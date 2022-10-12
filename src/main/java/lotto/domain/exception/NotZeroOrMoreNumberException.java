package lotto.domain.exception;

public class NotZeroOrMoreNumberException extends RuntimeException {

    private static final NotZeroOrMoreNumberException NOT_NUMBER_STRING_EXCEPTION
            = new NotZeroOrMoreNumberException("0이상의 수가 아닙니다.");

    private NotZeroOrMoreNumberException(String message) {
        super(message);
    }

    public static NotZeroOrMoreNumberException of() {
        return NOT_NUMBER_STRING_EXCEPTION;
    }
}
