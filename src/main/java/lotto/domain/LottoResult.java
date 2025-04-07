package lotto.domain;

import java.util.Map;

public class LottoResult {
    private final Map<LottoPrize, Integer> lottoPrizes;
    private final double rate;

    public LottoResult(Map<LottoPrize, Integer> lottoPrizes, int purchaseAmount) {
        this.lottoPrizes = lottoPrizes;
        this.rate = calculateRate(purchaseAmount);
    }

    private long calculateTotalWinningMoney() {
        return lottoPrizes.entrySet()
                .stream()
                .mapToLong(entry -> (long) entry.getKey().getWinningMoney() * entry.getValue())
                .sum();
    }

    public double calculateRate(int purchaseAmount) {
        long totalWinningMoney = calculateTotalWinningMoney();
        return (double) totalWinningMoney / purchaseAmount;
    }

    public Map<LottoPrize, Integer> getLottoPrizes() {
        return lottoPrizes;
    }

    public double getRate() {
        return rate;
    }
}
