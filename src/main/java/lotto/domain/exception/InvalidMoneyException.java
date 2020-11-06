package lotto.domain.exception;

public class InvalidMoneyException extends RuntimeException {
    private static final String MESSAGE = "금액은 0보다 커야합니다.";

    public InvalidMoneyException() {
        super(MESSAGE);
    }
}
