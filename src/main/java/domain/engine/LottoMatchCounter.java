package domain.engine;

import domain.model.LottoNumbers;
import static domain.constant.LottoConstants.MATCH_PRICES;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMatchCounter {
    private final LottoNumbers winNumbers;

    public LottoMatchCounter(LottoNumbers winNumbers) {
        this.winNumbers = winNumbers;
    }

    public Map<Integer, Integer> countMatches(List<LottoNumbers> lottos) {
        Map<Integer, Integer> matchResult = new HashMap<>();
        for (LottoNumbers lotto : lottos) {
            int matchCount = countMatch(lotto);
            if (MATCH_PRICES.containsKey(matchCount)) {
                matchResult.put(matchCount, matchResult.getOrDefault(matchCount, 0) + 1);
            }
        }
        return matchResult;
    }

    public double calculateProfit(Map<Integer, Integer> matchResult, int purchaseAmount) {
        int totalPrize = 0;
        for (int matchCount : matchResult.keySet()) {
            totalPrize += matchResult.get(matchCount) * MATCH_PRICES.getOrDefault(matchCount, 0);
        }
        return (double) totalPrize / purchaseAmount;
    }

    private int countMatch(LottoNumbers lotto) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (this.winNumbers.getNumbers().contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
