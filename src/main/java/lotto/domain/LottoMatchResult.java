package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoMatchResult {

    private static final double BASE_RATE = 1.0;

    private final Map<LottoMatch, Integer> matchResult;

    private LottoMatchResult() {
        this.matchResult = new HashMap<>();
    }

    public static LottoMatchResult newInstance() {
        return new LottoMatchResult();
    }

    public void increaseMatchCount(LottoMatch lottoMatch) {
        if (lottoMatch != null) {
            this.matchResult.put(lottoMatch, getMatchCount(lottoMatch) + 1);
        }
    }

    public int getMatchCount(LottoMatch lottoMatch) {
        return this.matchResult.getOrDefault(lottoMatch, 0);
    }

    public long calculateWinAmount(LottoMatch lottoMatch) {
        return lottoMatch.calculateWinAmount(getMatchCount(lottoMatch));
    }

    public double calculateProfitRate(PurchaseAmount purchaseAmount) {
        return getTotalWinAmount() * 1.0 / purchaseAmount.getPurchaseAmount();
    }

    private long getTotalWinAmount() {
        return this.matchResult.keySet().stream()
                .mapToLong(this::calculateWinAmount)
                .sum();
    }

    public String getProfitOrLoss(double profitRate) {
        return profitRate >= BASE_RATE ? "이익" : "손해";
    }
}
