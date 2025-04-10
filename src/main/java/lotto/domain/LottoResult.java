package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoPrize, Integer> lottoPrizes;
    private final double rate;

    public LottoResult(LottoPurchase lottoPurchase, LottoWinnings lottoWinnings) {
        Map<LottoPrize, Integer> lottoPrizes = new HashMap<>();
        for (Lotto lotto : lottoPurchase.getLottoList()) {
            LottoPrize lottoPrize = lottoWinnings.countMatches(lotto);
            lottoPrizes.put(lottoPrize, lottoPrizes.getOrDefault(lottoPrize, 0) + 1);
        }
        this.lottoPrizes = lottoPrizes;
        this.rate = calculateRate(lottoPurchase.getPurchaseAmount());
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
