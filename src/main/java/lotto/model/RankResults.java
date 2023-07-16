package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class RankResults {

    private final List<Rank> ranks;

    public RankResults(final List<Rank> ranks) {
        this.ranks = ranks;
    }

    public static RankResults add(
            final RankResults manualRankResults,
            final RankResults autoRankResults) {
        List<Rank> ranks = new ArrayList<>(manualRankResults.ranks);
        ranks.addAll(autoRankResults.ranks);
        return new RankResults(ranks);
    }

    public Map<Rank, Long> getRanksCounts() {
        return ranks.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public List<Rank> getRanks() {
        return new ArrayList<>(ranks);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RankResults that = (RankResults) o;
        return Objects.equals(ranks, that.ranks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ranks);
    }
}
