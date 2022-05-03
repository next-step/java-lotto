package lotto.exception;

public class InvalidMoneyInputException extends RuntimeException {

    public static final String INVALID_MONEY_INPUT_ERROR_MESSAGE = "입력금액은 1000원 이상이어야 합니다.";

    public InvalidMoneyInputException() {
        super(INVALID_MONEY_INPUT_ERROR_MESSAGE);
    }
}
