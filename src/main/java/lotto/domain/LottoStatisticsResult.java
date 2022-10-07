package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoStatisticsResult {

    private final Map<LottoRank, Long> countByRank;

    public LottoStatisticsResult(Map<LottoRank, Long> countByRank) {
        this.countByRank = countByRank;
    }

    public static LottoStatisticsResult from(List<LottoRank> ranks) {
        Map<LottoRank, Long> countByRank = ranks.stream()
                .collect(Collectors.groupingBy(
                        rank -> rank,
                        Collectors.counting()
                ));
        return new LottoStatisticsResult(countByRank);
    }

    public long getCountByRank(LottoRank rank) {
        return countByRank.containsKey(rank) ? countByRank.get(rank) : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoStatisticsResult that = (LottoStatisticsResult) o;
        return Objects.equals(countByRank, that.countByRank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countByRank);
    }

    @Override
    public String toString() {
        return "LottoStatisticsResult{" +
                "countByRank=" + countByRank +
                '}';
    }

}
