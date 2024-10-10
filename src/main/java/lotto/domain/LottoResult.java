package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static final int DEFAULT_VALUE = 0;
    private static final int PLUS_VALUE = 1;

    private final Map<LottoReward, Integer> resultMap;

    public LottoResult(final List<LottoReward> lottoRewards) {
        resultMap = new EnumMap<>(LottoReward.class);
        Arrays.stream(LottoReward.values()).forEach(lottoReward -> resultMap.put(lottoReward, DEFAULT_VALUE));
        for (LottoReward lottoReward : lottoRewards) {
            resultMap.replace(lottoReward, resultMap.get(lottoReward) + PLUS_VALUE);
        }
    }

    public Map<LottoReward, Integer> getResultMap() {
        return Collections.unmodifiableMap(resultMap);
    }

    public double calculateProfit() {
        int purchaseCount = calculatePurchasedMoneyCount();
        return calculateTotalPrize() / ((double) purchaseCount * LottoGenerator.PRICE_MONEY_UNIT);
    }

    private int calculatePurchasedMoneyCount() {
        return resultMap.values().stream()
                .reduce(DEFAULT_VALUE, Integer::sum);
    }

    private int calculateTotalPrize() {
        return resultMap.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
