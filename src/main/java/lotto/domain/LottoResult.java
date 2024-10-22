package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRewards, Integer> resultMap;

    public LottoResult(final List<LottoRewards> lottoRewards) {
        this.resultMap = new EnumMap<>(LottoRewards.class);
        for (LottoRewards lottoReward : LottoRewards.values()) {
            resultMap.put(lottoReward, Collections.frequency(lottoRewards, lottoReward));
        }
    }

    public Map<LottoRewards, Integer> getResultMap() {
        return resultMap;
    }

    public double calculateProfit(final LottoPurchaseInfo lottoPurchaseInfo) {
        return (double) calculateTotalPrize() / lottoPurchaseInfo.getMoney();
    }

    private int calculateTotalPrize() {
        return resultMap.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
