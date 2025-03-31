package domain.engine;

import domain.model.LottoNumbers;
import domain.model.Lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMatchCounter {
    public static final Map<Integer, Integer> MATCH_PRICES = Map.of(
            3, 5000,
            4, 50000,
            5, 1500000,
            6, 2000000000
    );
    private LottoNumbers winNumbers;

    public LottoMatchCounter(LottoNumbers winNumbers) {
        this.winNumbers = winNumbers;
    }

    public Map<Integer, Integer> countMatches(List<Lotto> lottos) {
        Map<Integer, Integer> matchResult = new HashMap<>();
        for (Lotto lotto : lottos) {
            int matchCount = countMatch(lotto);
            if (MATCH_PRICES.containsKey(matchCount)) {
                matchResult.put(matchCount, matchResult.getOrDefault(matchCount, 0) + 1);
            }
        }
        return matchResult;
    }

    private int countMatch(Lotto lotto) {
        int matchCount = 0;
        for (int number : lotto.getLottoNumbers()) {
            if (this.winNumbers.getNumbers().contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public double calculateProfit(Map<Integer, Integer> matchResult, int purchaseAmount) {
        int totalPrize = 0;
        for (int matchCount : matchResult.keySet()) {
            totalPrize += matchResult.get(matchCount) * MATCH_PRICES.getOrDefault(matchCount, 0);
        }
        return (double) totalPrize / purchaseAmount;
    }
}
