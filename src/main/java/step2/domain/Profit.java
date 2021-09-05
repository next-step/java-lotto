package step2.domain;

import step2.vo.Rank;

import java.util.Objects;

public class Profit {
    private long profit;
    private ProfitRate profitRate;

    public Profit(long profit) {
        this.profit = profit;
        this.profitRate = new ProfitRate();
    }

    public Profit() {
        this(0);
    }

    public Profit(long profit, double profitRate) {
        this.profit = profit;
        this.profitRate = new ProfitRate(profitRate);
    }

    public void add(Rank rank) {
        this.profit += rank.winnings;
    }

    public void calculateProfitRate(int inputPrice) {
        this.profitRate = new ProfitRate(this.profit / (double) inputPrice);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("총 수익률은 ")
                .append(this.profitRate)
                .append("입니다.")
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profit)) return false;
        Profit profit1 = (Profit) o;
        return profit == profit1.profit && Objects.equals(profitRate, profit1.profitRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profit, profitRate);
    }
}
