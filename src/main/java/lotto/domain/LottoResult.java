package lotto.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class LottoResult {

    private final int resultRankCount;
    private final Rank resultRank;

    public LottoResult(final int resultRankCount, final Rank resultRank) {
        this.resultRankCount = resultRankCount;
        this.resultRank = resultRank;
    }

    BigDecimal calculateRewards() {
        return BigDecimal.valueOf(resultRankCount).multiply(BigDecimal.valueOf(resultRank.getRewards()));
    }

    public int getResultRankCount() {
        return resultRankCount;
    }

    public Rank getResultRank() {
        return resultRank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return resultRankCount == that.resultRankCount &&
                resultRank == that.resultRank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultRankCount, resultRank);
    }
}
