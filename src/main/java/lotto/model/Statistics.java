package lotto.model;

import static lotto.model.Rank.getRank;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Statistics {

    private static final int PRICE_OF_A_LOTTO = 1000;
    private static final int HUNDRED = 100;
    private static Map<Rank, Integer> ranks;
    private double totalPrice;
    private double totalPrize;

    public Statistics(int lottoAmount) {
        ranks = new EnumMap<>(Rank.class);
        initializeRanks();
        this.totalPrice = lottoAmount * PRICE_OF_A_LOTTO;
        this.totalPrize = 0;
    }

    private void initializeRanks() {
        for (Rank rank : Rank.values()) {
            putRank(rank);
        }
    }

    public Map<Rank, Integer> updateRanks(List<MatchInfo> matchInfos) {
        for (MatchInfo matchInfo: matchInfos) {
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

    private void calculateTotalPrize() {
        for (Rank key : ranks.keySet()) {
            totalPrize += ranks.get(key);
        }
    }

    public double calculateBenefits() {
        calculateTotalPrize();
        return Math.floor((totalPrize / totalPrice) * HUNDRED) / HUNDRED;
    }

}
