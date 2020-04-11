package lotto.domain.money;

public class NotAffordableMoneyException extends IllegalArgumentException {
    public NotAffordableMoneyException() {
        super("금액이 충분하지 않습니다.");
    }
}
