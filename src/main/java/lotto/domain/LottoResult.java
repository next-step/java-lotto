package lotto.domain;

import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<LottoPrize, Integer> matchesResult = LottoPrize.makeLottoResult();

    public LottoResult(List<Integer> matchesCounts) {
        for (Integer matchesCount : matchesCounts) {
            LottoPrize lottoPrize = LottoPrize.getWinningPrize(matchesCount);
            makeLottoResult(lottoPrize);
        }
    }

    private void makeLottoResult(LottoPrize lottoPrize) {
        if (lottoPrize != LottoPrize.LOST) {
            int countPerPrize = matchesResult.get(lottoPrize);
            matchesResult.put(lottoPrize, ++countPerPrize);
        }
    }

    public double calculateRate(int purchaseAmount) {
        long totalPrize = matchesResult.entrySet()
                .stream()
                .filter(o -> o.getValue() > 0)
                .mapToLong(o -> (long) o.getKey().money() * o.getValue())
                .sum();

        return  (double) totalPrize / purchaseAmount;
    }

    public long calculateTotalPrize() {
        return matchesResult.entrySet()
                .stream()
                .filter(o -> o.getValue() > 0)
                .mapToLong(o -> (long) o.getKey().money() * o.getValue())
                .sum();
    }

    public Map<LottoPrize, Integer> getMatchesResult() {
        return matchesResult;
    }
}
