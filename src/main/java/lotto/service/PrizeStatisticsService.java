package lotto.service;

import lotto.model.Lotto;
import lotto.model.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PrizeStatisticsService {
    private static final int MAX_PRIZE_RANK = 5;
    private Map<Rank, Integer> criteriaCounts;

    public void calculate(List<Lotto> lottos, Set<Integer> prizeNumbers) {
        this.criteriaCounts = new HashMap<>();

        Rank rank;
        int matchCount;
        for (Lotto lotto : lottos) {
            matchCount = lotto.getMatchCount(prizeNumbers);
            rank = Rank.valueOf(matchCount, false);
            if (this.criteriaCounts.containsKey(rank)) {
                this.criteriaCounts.replace(rank, this.criteriaCounts.get(rank) + 1);
                continue;
            }

            this.criteriaCounts.put(rank, 1);
        }
    }

    public double getReturnsOfInvestment(int money) {
        return money / (double) this.getTotalPrizePrice();
    }

    private int getTotalPrizePrice() {
        return this.criteriaCounts.entrySet().stream()
                .filter(entry -> entry.getKey().ordinal() <= MAX_PRIZE_RANK)
                .mapToInt(entry -> entry.getKey().getWinningMoney() * entry.getValue())
                .sum();
    }
}
