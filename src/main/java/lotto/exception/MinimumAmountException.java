package lotto.exception;

public class MinimumAmountException extends IllegalArgumentException{

    private static final String ERROR_MESSAGE = "잔액이 부족합니다. (잔액: %d)";

    public MinimumAmountException(long amount) {
        super(String.format(ERROR_MESSAGE, amount));
    }
}
