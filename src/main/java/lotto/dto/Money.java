package lotto.dto;

public class Money {
    private final static int LOTTO_PRICE = 1000;
    private int money;

    public Money(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException();
        }
        this.money = money;
    }

    public int getMoney() {
        return this.money;
    }
}
