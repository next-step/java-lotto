package lotto.model;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoStatistics {
    private static final int ZERO_VALUE = 0;
    private static final int INCREASE_VALUE = 1;

    private final Map<LottoPrize, Integer> statisticsMap;
    private double earningsRate;

    private LottoStatistics(final int payment, final Lottos lottos) {
        this.statisticsMap = new EnumMap<>(LottoPrize.class);

        calculateStatistics(lottos);
        calculateEarningsRate(payment, lottos);
    }

    public static LottoStatistics from(final int payment, final Lottos lottos) {
        return new LottoStatistics(payment, lottos);
    }

    private void calculateStatistics(final Lottos lottos) {
        lottos.stream()
              .map(lotto -> LottoPrize.findByMatchCount(lotto.matchCount()))
              .forEach(lottoPrize -> statisticsMap.put(lottoPrize, statisticsMap.getOrDefault(lottoPrize, ZERO_VALUE) + INCREASE_VALUE));
    }

    private void calculateEarningsRate(final int payment, final Lottos lottos) {
        int totalProfitMoney = lottos.stream()
                                     .map(Lotto::prize)
                                     .reduce(ZERO_VALUE, Integer::sum);

        if (totalProfitMoney == ZERO_VALUE) {
            this.earningsRate = ZERO_VALUE;
            return;
        }

        this.earningsRate = payment / (double) totalProfitMoney;
    }

    public Map<LottoPrize, Integer> getStatisticsMap() {
        return Collections.unmodifiableMap(statisticsMap);
    }

    public double getEarningsRate() {
        return earningsRate;
    }
}
