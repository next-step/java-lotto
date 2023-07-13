package lotto.model.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public final class RankResults {

    private static final int DEFAULT_VALUE = 0;

    private final List<Rank> ranks;

    public RankResults(final List<Rank> ranks) {
        this.ranks = ranks;
    }

    public RankResults(final RankResults rankResults1, final RankResults rankResults2) {
        this.ranks = new ArrayList<>(rankResults1.ranks);
        this.ranks.addAll(rankResults2.ranks);
    }

    public Map<Rank, Integer> getRanksCounts() {

        EnumMap<Rank, Integer> ranksCounts = new EnumMap<>(Rank.class);
        ranks.forEach(rank -> ranksCounts.put(
                rank,
                ranksCounts.getOrDefault(rank, DEFAULT_VALUE) + 1
        ));
        return ranksCounts;
    }

    public List<Rank> getRanks() {
        return new ArrayList<>(ranks);
    }
}
