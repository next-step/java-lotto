package step2.domain.statistics;

import java.util.Objects;

public class Profit {
    private Revenue revenue;
    private Amount totalPurchaseAmount;

    public Profit() {
        this.revenue = new Revenue(0);
        this.totalPurchaseAmount = new Amount(0);
    }

    public Profit(Revenue revenue, Amount totalPurchaseAmount) {
        this.revenue = revenue;
        this.totalPurchaseAmount = totalPurchaseAmount;
    }

    public void add(Rank rank) {
        this.revenue.add(rank);
        this.totalPurchaseAmount = this.totalPurchaseAmount.add();
    }

    public ProfitRate profitRate() {
        return this.revenue.calculateProfitRate(this.totalPurchaseAmount);
    }


    @Override
    public String toString() {
        return "Profit{" +
                "revenue=" + revenue +
                ", totalPurchaseAmount=" + totalPurchaseAmount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profit)) return false;
        Profit that = (Profit) o;
        return Objects.equals(revenue, that.revenue) && Objects.equals(totalPurchaseAmount, that.totalPurchaseAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(revenue, totalPurchaseAmount);
    }
}
