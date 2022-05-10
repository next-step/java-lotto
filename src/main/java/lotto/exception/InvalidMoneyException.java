package lotto.exception;

public class InvalidMoneyException extends RuntimeException {

    public static final String INVALID_MONEY_ERROR_MESSAGE = "돈은 음수일 수 없습니다.";

    public InvalidMoneyException() {
        super(INVALID_MONEY_ERROR_MESSAGE);
    }
}
