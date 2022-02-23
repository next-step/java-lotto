package lotto.model;

import static lotto.model.Rank.getRank;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Ranks {

    private static final int ZERO = 0;
    private static final int ONE = 1;

    private final Map<Rank, Integer> ranks;

    public Ranks() {
        this.ranks = new EnumMap<>(Rank.class);
        initializeRanks();
    }

    private void initializeRanks() {
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
        ranks.put(rank, ranks.get(rank) + ONE);
    }

    private void putRank(Rank rank) {
        ranks.put(rank, ZERO);
    }

    public int calculateTotalLottoCount() {
        int totalCount = 0;
        for (Rank key : ranks.keySet()) {
            totalCount += ranks.get(key);
        }
        return totalCount;
    }

    public int calculateTotalPrize() {
        int totalPrize = ZERO;
        for (Rank key : ranks.keySet()) {
            totalPrize += key.getReward() * ranks.get(key);
        }
        return totalPrize;
    }
}
