package step2.domain.statistics;

import java.util.Objects;

public class ProfitRate {
    private double profitRate;

    public ProfitRate(double profitRate) {
        this.profitRate = profitRate;
    }

    public ProfitRate() {
        this(1.0);
    }

    public ProfitRate calculateProfitRate(Profit profit, Amount amount) {
        return profit.calculateProfitRate(amount);
    }


    @Override
    public String toString() {
        return new StringBuilder()
                .append("총 수익률은 ")
                .append(Math.floor(this.profitRate * 100) / 100.0)
                .append("입니다.")
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfitRate)) return false;
        ProfitRate that = (ProfitRate) o;
        return Double.compare(that.profitRate, profitRate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(profitRate);
    }
}
