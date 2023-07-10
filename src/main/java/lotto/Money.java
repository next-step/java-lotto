package lotto;

public class Money {

    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("돈이 음수일 수 없습니다.");
        }
    }
}
