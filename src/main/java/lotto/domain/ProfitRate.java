package lotto.domain;

import java.util.Objects;

public class ProfitRate {

    private final double profitRate;

    public ProfitRate(double profitRate) {
        validateProfitRate(profitRate);
        this.profitRate = profitRate;
    }

    private void validateProfitRate(double profit) {
        if (profit < 0) {
            throw new IllegalArgumentException(String.format("수익률이 0 미만으로 될 수 없습니다. 현재 값: %.2f", profit));
        }
    }

    public double getProfitRate() {
        return profitRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfitRate that = (ProfitRate) o;
        return Double.compare(that.profitRate, profitRate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(profitRate);
    }

    @Override
    public String toString() {
        return "ProfitRate{" +
                "profitRate=" + profitRate +
                '}';
    }
}
