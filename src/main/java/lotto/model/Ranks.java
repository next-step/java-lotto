package lotto.model;

import static lotto.model.Rank.getRank;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Ranks {

    private static Map<Rank, Integer> ranks;
    private static final int ZERO = 0;
    private static final int ONE = 1;

    public Ranks() {
        initializeRanks();
    }

    private void initializeRanks() {
        ranks = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            putRank(rank);
        }
    }

    public Map<Rank, Integer> updateRanks(List<MatchInfo> matchInfos) {
        for (MatchInfo matchInfo : matchInfos) {
            int matchCount = matchInfo.getMatchCount();
            boolean bonusMatch = matchInfo.getBonusMatch();
            Rank rank = getRank(matchCount, bonusMatch);
            incrementRank(rank);
        }
        return ranks;
    }

    private void incrementRank(Rank rank) {
        if (rank != Rank.MISS) {
            ranks.put(rank, ranks.get(rank) + ONE);
        }
    }

    private void putRank(Rank rank) {
        if (rank != Rank.MISS) {
            ranks.put(rank, ZERO);
        }
    }

}
