package lotto.domain;

import java.util.Objects;

public class ProfitRate {

    private final double profitRate;
    private final String PROFITRATE_NEGATIVE_EXCEPTION = "수익률은 음수일 수 없습니다.";

    public ProfitRate(double profitRate) {
        if (profitRate < 0) {
            throw new IllegalArgumentException(PROFITRATE_NEGATIVE_EXCEPTION);
        }
        this.profitRate = profitRate;
    }

    public boolean loss() {
        return profitRate < 1;
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
        return String.format("%.2f", profitRate);
    }
}
