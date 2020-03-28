package lotto.domain;

public class NotEnoughtMoneyException extends IllegalArgumentException {
    public NotEnoughtMoneyException() {
        super("구입 금액은 1000원 이상이어야 합니다");
    }
}
