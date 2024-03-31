package lotto.domain.reward;

import static lotto.domain.publish.LottoCalculator.LOTTO_PRICE_PER_UNIT;

import java.util.Collections;
import java.util.Map;

public class LottoResult {

    private static final double FLOOR_STANDARD = 100.0;

    private final Map<LottoRank, Long> result;

    public LottoResult(final Map<LottoRank, Long> result) {
        this.result = result;
    }

    public Map<LottoRank, Long> result() {
        return Collections.unmodifiableMap(this.result);
    }

    public double profitRate() {
        return floor(calculateProfitRate(this.result));
    }

    private static double calculateProfitRate(final Map<LottoRank, Long> result) {
        final long totalProfit = result.keySet()
                .stream()
                .mapToLong(rank -> rank.rewardAmount() * result.get(rank))
                .sum();

        return (double)totalProfit / totalPrice(result);
    }

    private static long totalPrice(final Map<LottoRank, Long> result) {
        final long lottoAmount = result.values()
                .stream()
                .mapToLong(Long::longValue)
                .sum();

        return LOTTO_PRICE_PER_UNIT * lottoAmount;
    }

    private static double floor(final double rate) {
        return Math.floor(rate * FLOOR_STANDARD) / FLOOR_STANDARD;
    }
}
