package lotto.domain.money;

public class NotEnoughMoneyException extends IllegalArgumentException {
    public NotEnoughMoneyException() {
        super("구입 금액은 1000원 이상이어야 합니다");
    }
}
