package lotto;

public class Money {
    private static final int LOTTERY_MONEY = 1_000;
    private final int money;

    public Money(String money) {
        this(Integer.parseInt(money));
    }

    public Money(int money) {
        if (money < LOTTERY_MONEY)
            throw new IllegalArgumentException();
        this.money = money;
    }

    public int lotteryCount() {
        return money / LOTTERY_MONEY;
    }
}
