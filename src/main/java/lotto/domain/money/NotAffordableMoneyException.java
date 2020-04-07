package lotto.domain.money;

public class NotAffordableMoneyException extends IllegalArgumentException {
    public NotAffordableMoneyException() {
        super("입력한 금액을 초과하여 구매할 수 없습니다.");
    }
}
