package lotto.domain;

import java.util.Map;
import java.util.Objects;

public class RankResult {
    private Map<Rank, Long> rankStatistics;

    public RankResult(Map<Rank, Long> rankStatistics) {
        this.rankStatistics = rankStatistics;
    }

    public long calculateTotalPrizeMoney() {
        return rankStatistics.entrySet().stream()
                .mapToLong(
                        rankStatistics -> rankStatistics.getKey().calculateTotalPrizePerRank(rankStatistics.getValue()))
                .reduce(0L, Long::sum);
    }

    public Map<Rank, Long> getRankStatistics() {
        return rankStatistics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RankResult that = (RankResult) o;
        return Objects.equals(rankStatistics, that.rankStatistics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rankStatistics);
    }

    @Override
    public String toString() {
        return "RankResult{" +
                "rankStatistics=" + rankStatistics +
                '}';
    }
}
