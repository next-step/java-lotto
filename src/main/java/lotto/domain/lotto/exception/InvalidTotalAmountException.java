package lotto.domain.lotto.exception;

public class InvalidTotalAmountException extends RuntimeException {

    private static final String MESSAGE = "로또 최소 금액은 %d원 입니다.";

    public InvalidTotalAmountException(int minimum) {
        super(String.format(MESSAGE, minimum));
    }
}
