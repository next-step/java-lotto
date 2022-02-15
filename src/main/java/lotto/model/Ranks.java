package lotto.model;

import static lotto.model.Rank.getRank;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Ranks {

    private static Map<Rank, Integer> ranks;

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
            ranks.put(rank, ranks.get(rank) + 1);
        }
    }

    private void putRank(Rank rank) {
        if (rank != Rank.MISS) {
            ranks.put(rank, 0);
        }
    }

    public int calculateTotalPrize() {
        int totalPrize = 0;
        for (Rank key : ranks.keySet()) {
            totalPrize += key.getReward() * ranks.get(key);
        }
        return totalPrize;
    }
}
