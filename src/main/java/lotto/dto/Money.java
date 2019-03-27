package lotto.dto;

public class Money {
    private final static int LOTTO_PRICE = 1_000;
    private long money;

    public Money(long money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException();
        }
        this.money = money;
    }

    public long getMoney() {
        return this.money;
    }
}
