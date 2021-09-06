package step2.domain.statistics;

import step2.vo.Rank;

import java.util.Map;
import java.util.Objects;

public class WinningStatistics {
    private Match match;
    private Profit profit;
    private ProfitRate profitRate;
    private Amount totalPurchaseAmount;

    public WinningStatistics() {
        this.match = new Match();
        this.profit = new Profit(0);
        this.profitRate = new ProfitRate(1.0);
        this.totalPurchaseAmount = new Amount(0);
    }

    public WinningStatistics(Map<Rank, Integer> match, long profit, double profitRate, int totalPurchaseAmount) {
        this.match = new Match(match);
        this.profit = new Profit(profit);
        this.totalPurchaseAmount = new Amount(totalPurchaseAmount);
        this.profitRate = new ProfitRate(profitRate);
    }

    public void add(Rank rank) {
        this.match.add(rank);
        this.profit.add(rank);
        this.totalPurchaseAmount = this.totalPurchaseAmount.add();
        this.profitRate = this.profit.calculateProfitRate(this.totalPurchaseAmount);
    }


    @Override
    public String toString() {
        return new StringBuilder().append("당첨 통계\n")
                .append("---------\n")
                .append(this.match)
                .append(this.profitRate)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WinningStatistics)) return false;
        WinningStatistics winningStatistics1 = (WinningStatistics) o;
        return Objects.equals(match, winningStatistics1.match) && Objects.equals(profit, winningStatistics1.profit) && Objects.equals(profitRate, winningStatistics1.profitRate) && Objects.equals(totalPurchaseAmount, winningStatistics1.totalPurchaseAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(match, profit, profitRate, totalPurchaseAmount);
    }
}
