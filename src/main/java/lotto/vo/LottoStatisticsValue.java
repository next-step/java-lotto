package lotto.vo;

import java.util.Objects;

import lotto.domain.PrizeLevel;

public class LottoStatisticsValue {
    private final PrizeLevel prizeLevel;
    private final int count;

    public LottoStatisticsValue(PrizeLevel prizeLevel, int count) {
        this.prizeLevel = prizeLevel;
        this.count = count;
    }

    public PrizeLevel getPrizeLevel() {
        return prizeLevel;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoStatisticsValue that = (LottoStatisticsValue) o;
        return count == that.count && prizeLevel == that.prizeLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prizeLevel, count);
    }
}
