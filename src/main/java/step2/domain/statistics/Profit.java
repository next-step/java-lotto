package step2.domain.statistics;

import step2.vo.Rank;

import java.util.Objects;

public class Profit {
    private long profit;

    public Profit(long profit) {
        this.profit = profit;
    }

    public Profit() {
        this(0);
    }

    public Profit(long profit, double profitRate) {
        this.profit = profit;
    }

    public void add(Rank rank) {
        this.profit += rank.winnings;
    }

    public ProfitRate calculateProfitRate(Amount amount) {
        return new ProfitRate(this.profit / amount.price());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profit)) return false;
        Profit profit1 = (Profit) o;
        return profit == profit1.profit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(profit);
    }

    @Override
    public String toString() {
        return "Profit{" +
                "profit=" + profit +
                '}';
    }
}
