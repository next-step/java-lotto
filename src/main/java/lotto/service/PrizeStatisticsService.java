package lotto.service;

import lotto.model.Lotto;
import lotto.model.PrizePrice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PrizeStatisticsService {
    private static final int MIN_PRIZE_COUNT = 3;
    private Map<PrizePrice, Integer> criteriaCounts;

    public void calculate(List<Lotto> lottos, Set<Integer> prizeNumbers) {
        this.criteriaCounts = new HashMap<>();

        PrizePrice prizePrice;
        int matchCount;
        for (Lotto lotto : lottos) {
            matchCount = lotto.getMatchCount(prizeNumbers);
            prizePrice = PrizePrice.valueOf(matchCount);
            if (this.criteriaCounts.containsKey(prizePrice)) {
                this.criteriaCounts.replace(prizePrice, this.criteriaCounts.get(prizePrice) + 1);
                continue;
            }

            this.criteriaCounts.put(prizePrice, 1);
        }
    }

    public int getMatchCount(int criteria) {
        return this.criteriaCounts.containsKey(PrizePrice.valueOf(criteria)) ?
                this.criteriaCounts.get(PrizePrice.valueOf(criteria)) : 0;
    }

    public double getReturnsOfInvestment(int money) {
        return money / (double) this.getTotalPrizePrice();
    }

    private int getTotalPrizePrice() {
        return this.criteriaCounts.entrySet().stream()
                .filter(entry -> entry.getKey().ordinal() >= MIN_PRIZE_COUNT)
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }
}
