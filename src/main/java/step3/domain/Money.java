package step3.domain;

import step3.exception.NotEnoughInitMoneyException;

public class Money {

    int money;

    public Money(int money) {
        checkInRange(money);

        this.money = money;
    }

    public void buyOneLotto() {
        this.money -= 1000;
    }

    public boolean hasEnoughMoney() {
        return money >= 1000;
    }

    private void checkInRange(int money) {
        if (money < 1000) {
            throw new NotEnoughInitMoneyException();
        }
    }
}
