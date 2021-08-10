package app.domain;

public class Money {
    private int money;

    private Money(int money) {
        validation(money);
        this.money = money;
    }

    public static Money of(int money) {
        return new Money(money);
    }

    private void validation(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("Error 0 이상만 입력 가능합니다. " + money);
        }
    }

    public int getMoney() {
        return money;
    }

    public int countLotto(int price) {
        return this.money / price;
    }
}
