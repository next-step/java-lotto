package lotto;

public class Money {

    private final long money;

    public Money(long money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(long money) {
        if (money < 0) {
            throw new IllegalArgumentException("돈이 음수일 수 없습니다.");
        }
    }
}
