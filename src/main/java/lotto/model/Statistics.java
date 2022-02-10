package lotto.model;

import static lotto.model.Rank.getRank;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Statistics {

    private static final int PRICE_OF_A_LOTTO = 1000;

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

    public Map<Rank, Integer> updateRanks(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchCount();
            boolean bonusMatch = lotto.getBonusMatch();
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
        Iterator<Rank> keys = ranks.keySet().iterator();
        while (keys.hasNext()) {
            Rank key = keys.next();
            totalPrize += ranks.get(key);
        }
    }

    public double calculateBenefits() {
        calculateTotalPrize();
        return Math.floor((totalPrize / totalPrice) * 100) / 100;
    }

}
