package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static final int LOTTO_PRICE = 1_000;

    private final Map<LottoPrize, Integer> matchesResult = LottoPrize.makeLottoResult();

    public LottoResult(List<LottoPrize> winningPrize) {
        winningPrize.forEach(this::makeLottoResult);
    }

    private void makeLottoResult(LottoPrize lottoPrize) {
        if (lottoPrize != LottoPrize.LOST) {
            int countPerPrize = matchesResult.get(lottoPrize);
            matchesResult.put(lottoPrize, ++countPerPrize);
        }
    }

    public double calculateRate(int purchaseCount) {
        long totalPrize = matchesResult.entrySet()
                .stream()
                .filter(o -> o.getValue() > 0)
                .mapToLong(o -> (long) o.getKey().money() * o.getValue())
                .sum();

        return (double) totalPrize / (purchaseCount * LOTTO_PRICE);
    }

    public long calculateTotalPrize() {
        return matchesResult.entrySet()
                .stream()
                .filter(o -> o.getValue() > 0)
                .mapToLong(o -> (long) o.getKey().money() * o.getValue())
                .sum();
    }

    public Map<LottoPrize, Integer> getMatchesResult() {
        return new LinkedHashMap<>(matchesResult);
    }
}
