package lotto.exception;

public class MinimumAmountException extends RuntimeException {
    private static final String MESSAGE = "최소 금액은 1000원 입니다. 입력금액(%s)";

    public MinimumAmountException(int money) {
        super(String.format(MESSAGE, money));
    }
}
