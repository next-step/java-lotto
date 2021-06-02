package lotto.exception;

public class OverMinusMoneyRequestException extends RuntimeException {
    public OverMinusMoneyRequestException() {
        super("구입 금액보다 많은 돈은 차감할 수 없습니다.");
    }
}
