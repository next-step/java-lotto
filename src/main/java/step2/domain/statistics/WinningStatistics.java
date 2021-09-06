package step2.domain.statistics;

import step2.vo.Rank;

import java.util.Objects;

public class WinningStatistics {
    private Profit profit;
    private Amount totalPurchaseAmount;

    public WinningStatistics() {
        this.profit = new Profit(0);
        this.totalPurchaseAmount = new Amount(0);
    }

    public WinningStatistics(Profit profit, Amount totalPurchaseAmount) {
        this.profit = profit;
        this.totalPurchaseAmount = totalPurchaseAmount;
    }

    public void add(Rank rank) {
        this.profit.add(rank);
        this.totalPurchaseAmount = this.totalPurchaseAmount.add();
    }


    public ProfitRate profitRate() {
        return this.profit.calculateProfitRate(this.totalPurchaseAmount);
    }

//    @Override
//    public String toString() {
//        return new StringBuilder().append("당첨 통계\n")
//                .append("---------\n")
//                .append(this.match)
////                .append(this.profitRate)
//                .toString();
//    }


    @Override
    public String toString() {
        return "WinningStatistics{" +
                "profit=" + profit +
                ", totalPurchaseAmount=" + totalPurchaseAmount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WinningStatistics)) return false;
        WinningStatistics that = (WinningStatistics) o;
        return Objects.equals(profit, that.profit) && Objects.equals(totalPurchaseAmount, that.totalPurchaseAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profit, totalPurchaseAmount);
    }
}
