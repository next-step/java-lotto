package lotto.domain.model;

import java.util.HashMap;
import java.util.Map;

import static lotto.constant.LottoConstants.MATCH_PRICES;

public class MatchResult {
    private final Map<Integer, Integer> resultMap = new HashMap<>();

    public double calculateProfit(int purchaseAmount) {
        return (double) getPrize() / purchaseAmount * 100;
    }

    public int getCount(int matchCount) {
        return this.resultMap.getOrDefault(matchCount, 0);
    }

    void addMatchCount(int matchCount) {
        if (MATCH_PRICES.containsKey(matchCount)) {
            this.resultMap.put(matchCount, this.resultMap.getOrDefault(matchCount, 0) + 1);
        }
    }

    private int getPrize() {
        int totalPrize = 0;
        for (int matchCount : this.resultMap.keySet()) {
            int count = this.resultMap.get(matchCount);
            totalPrize += MATCH_PRICES.get(matchCount) * count;
        }
        return totalPrize;
    }
}
