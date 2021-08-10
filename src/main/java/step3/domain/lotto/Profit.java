package step3.domain.lotto;

import step3.domain.money.Cache;
import java.util.Objects;

public class Profit {

    private static final int LOTTO_PRICE = 1000;

    private final double profit;

    public Profit() {
        this(0);
    }

    public Profit(double profit) {
        this.profit = profit;
    }

    public static Profit calcLottoProfit(Cache totalWinOfMoney, int count) {
        return new Profit((double) totalWinOfMoney.amount() / (count * LOTTO_PRICE));
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
