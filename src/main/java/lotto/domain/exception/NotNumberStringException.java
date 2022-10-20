package lotto.domain.exception;

public class NotNumberStringException extends LottoDomainException {

    private static final NotNumberStringException NOT_NUMBER_STRING_EXCEPTION =
            new NotNumberStringException("숫자가 아닌 문자가 입력되었습니다.");

    private NotNumberStringException(String message) {
        super(message);
    }

    public static NotNumberStringException getInstance() {
        return NOT_NUMBER_STRING_EXCEPTION;
    }
}
