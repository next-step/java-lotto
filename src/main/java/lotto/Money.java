package lotto;

public class Money {
    private int money;

    public Money(int money) {
        if (money < 0) {
            throw new IllegalArgumentException();
        }
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}
