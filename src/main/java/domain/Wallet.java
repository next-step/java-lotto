package domain;

public class Wallet {
    private Money money;

    public Wallet(Money money) {
        this.money = money;
    }

    public Money pay(Money money) {
        this.money = this.money.subtract(money);
        return money;
    }

    public Money payAll() {
        final Money money = this.money;
        this.money = new Money(0);
        return money;
    }

    public Money getMoney() {
        return money;
    }

    public boolean payable(Money money) {
        return this.money.value() >= money.value();
    }

    public Money charge(Money money) {
        this.money = this.money.add(money);
        return money;
    }
}
