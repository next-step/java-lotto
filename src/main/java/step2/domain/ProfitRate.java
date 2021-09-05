package step2.domain;

import java.util.Objects;

public class ProfitRate {
    private double profitRate;
//    private int purchasePrice;

    public ProfitRate() {
        this.profitRate = 1.0;
//        this.purchasePrice = 0;
    }

    public ProfitRate(double profitRate) {
        this.profitRate = profitRate;
    }

//    public void calculateProfitRate(int profit) {
//        this.profitRate = profit / (double) inputPrice;
//    }


    @Override
    public String toString() {
        return String.valueOf(Math.floor(this.profitRate * 100) / 100.0);
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
