package lotto.exception;

public class InsufficientPriceException extends RuntimeException {
    private static final String MESSAGE = "로또 최소 금액 단위는 1000원 입니다.";

    public InsufficientPriceException() {
        super(MESSAGE);
    }

}
