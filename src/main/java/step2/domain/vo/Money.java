package step2.domain.vo;

public class Money {

    private static final int MINIMUM_AMOUNT = 0;

    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (money < MINIMUM_AMOUNT) {
            throw new IllegalStateException("구입금액은 0원보다 커야 합니다. 현재 구입금액: " + money);
        }
    }

    public int getMoney() {
        return money;
    }
}
