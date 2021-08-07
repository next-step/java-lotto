package step2.domain.lotto;

import java.util.Objects;

public class Profit {

    private static final int LOTTO_PRICE = 1000;

    private final Double profit;

    public Profit() {
        this(0);
    }

    public Profit(double profit) {
        this.profit = profit;
    }

    public static Profit calcLottoProfit(Integer totalWinOfMoney, int money) {
        return new Profit((double) totalWinOfMoney / (money * LOTTO_PRICE));
    }

    @Override
    public String toString() {
        return profit + "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Profit profit1 = (Profit) o;
        return Objects.equals(profit, profit1.profit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profit);
    }
}
