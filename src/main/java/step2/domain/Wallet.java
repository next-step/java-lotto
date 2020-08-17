package step2.domain;

import java.util.Objects;

public class Wallet {

    private Money money;

    public Wallet(final int money) {
        this.money = new Money(money);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Objects.equals(money, wallet.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

    public int spend(int price, int quantity) {
        int spendMoney = price * quantity;

        if (this.money.toInt() < spendMoney)
            throw new IllegalArgumentException("잔고가 부족합니다.");

        this.money.subtraction(spendMoney);

        return this.money.toInt();
    }

    public int getQuantityOfItems(int price) {
        return this.money.getQuantityOfItems(price);
    }
}
