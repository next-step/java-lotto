package domain;

public class Money {
    private int money;

    private Money(int money) {
        this.money = money;
    }

    public static Money of(int money) {
        return new Money(money);
    }

    public float getYield(Money winMoney) {
        return winMoney.money / this.money;
    }
}
