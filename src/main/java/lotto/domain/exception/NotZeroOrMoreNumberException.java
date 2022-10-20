package lotto.domain.exception;

public class NotZeroOrMoreNumberException extends LottoDomainException {

    private static final NotZeroOrMoreNumberException NOT_ZERO_OR_MORE_NUMBER_EXCEPTION
            = new NotZeroOrMoreNumberException("0이상의 수가 아닙니다.");

    private NotZeroOrMoreNumberException(String message) {
        super(message);
    }

    public static NotZeroOrMoreNumberException getInstance() {
        return NOT_ZERO_OR_MORE_NUMBER_EXCEPTION;
    }
}
