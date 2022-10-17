package lotto.exception;

public class InvalidInputException extends IllegalArgumentException {

    private static final String MESSAGE = "구매 금액은 천원 단위의 양수만 입력할 수 있습니다.";

    public InvalidInputException() {
        super(MESSAGE);
    }
}
