package lotto.service;

import lotto.model.Lotto;
import lotto.model.PrizePrice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PrizeStatisticsService {
    private Map<Integer, Integer> criteriaCounts;

    public void calculate(List<Lotto> lottos, Set<Integer> prizeNumbers) {
        this.criteriaCounts = new HashMap<>();

        int matchCount;
        for (Lotto lotto : lottos) {
            matchCount = lotto.getMatchCount(prizeNumbers);
            if (this.criteriaCounts.containsKey(matchCount)) {
                this.criteriaCounts.replace(matchCount, this.criteriaCounts.get(matchCount) + 1);
                continue;
            }

            this.criteriaCounts.put(matchCount, 1);
        }
    }

    public int getMatchCount(int criteria) {
        return this.criteriaCounts.containsKey(criteria) ?
                this.criteriaCounts.get(criteria) : 0;
    }

    public double getReturnsOfInvestment(int money) {
        return money / (double) this.getTotalPrizePrice();
    }

    private int getTotalPrizePrice() {
        return this.criteriaCounts.entrySet().stream()
                .filter(entry -> entry.getKey() >= 3)
                .mapToInt(entry -> PrizePrice.getPrice(entry.getKey()) * entry.getValue())
                .sum();
    }
}
