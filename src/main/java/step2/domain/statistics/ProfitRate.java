package step2.domain.statistics;

import java.util.Objects;

public class ProfitRate {
    private final double profitRate;
    private final ProfitConclusion profitConclusion;

    public ProfitRate(double profitRate) {
        this.profitRate = profitRate;
        this.profitConclusion = new ProfitConclusion().profitConclusion(profitRate);
    }

    public ProfitRate() {
        this(1.0);
    }


    @Override
    public String toString() {
        final double profitRate = Math.floor(this.profitRate * 100) / 100.0;
        return new StringBuilder()
                .append("총 수익률은 ")
                .append(profitRate)
                .append("입니다.")
                .append("(기준이 1이기 때문에 결과적으로 ")
                .append(profitConclusion)
                .append("(이)라는 의미임)")
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
