package lotto.domain;

public class Cash {

    private static final int MINIMUM_MONEY = 1000;
    private final int money;

    public Cash(int money) {
        this.money = money;
    }

    public int getAmount() {
        if (money < MINIMUM_MONEY) throw new IllegalArgumentException();
        return money / MINIMUM_MONEY;
    }
}
