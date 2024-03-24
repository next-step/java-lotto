package lotto.domain;

public class Cash {

    private final int money;
    private static final int MINIMUM_MONEY = 1000;

    public Cash(int money) {
        this.money = money;
    }

    public int getAmount() {
        if (money < MINIMUM_MONEY) throw new IllegalArgumentException();
        return money / MINIMUM_MONEY;
    }

    @Override
    public String toString() {
        return String.format("%d개를 구매했습니다.", getAmount());
    }
}
