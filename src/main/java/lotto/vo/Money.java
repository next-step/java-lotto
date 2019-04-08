package lotto.vo;

import lotto.utils.Const;

public class Money {
    public static final int LOTTERY_PRICE = 1_000;
    public static final int PERCENT = 100;
    private final int money;

    public Money(String money) {
        this(Integer.parseInt(money));
    }

    public Money(int money) {
        if (money < LOTTERY_PRICE) {
            throw new IllegalArgumentException();
        }
        this.money = money;
    }

    public int buyingTicketCount() {
        return money / LOTTERY_PRICE;
    }

    public double yield(Money revenue) {
        return (double) ((revenue.money * PERCENT) / money) / PERCENT;
    }

    public double getProfit(Ranks ranks) {
        int revenue = Rank.sumProfit(ranks);
        if (revenue > Const.INITIAL_NUMBER)
            return new Money(money).yield(new Money(revenue));
        return Const.INITIAL_NUMBER;
    }
}
