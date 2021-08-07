package lotto.model;

import lotto.prize.LottoPrize;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {
    private static final int INCREASE_VALUE = 1;

    private final Map<LottoPrize, Integer> statisticsMap;
    private double earningsRate;

    private LottoStatistics(final Money payment, final List<LottoPrize> lottoPrizes) {
        this.statisticsMap = new EnumMap<>(LottoPrize.class);

        calculateStatistics(lottoPrizes);
        calculateEarningsRate(payment, lottoPrizes);
    }

    public static LottoStatistics from(final Money payment, final List<LottoPrize> lottoPrizes) {
        return new LottoStatistics(payment, lottoPrizes);
    }

    private void calculateStatistics(final List<LottoPrize> lottoPrizes) {
        lottoPrizes.forEach(lottoPrize -> statisticsMap.put(lottoPrize, statisticsMap.getOrDefault(lottoPrize, 0) + INCREASE_VALUE));
    }

    private void calculateEarningsRate(final Money payment, final List<LottoPrize> lottoPrizes) {
        Money totalProfitMoney = lottoPrizes.stream()
                                            .map(LottoPrize::getPrizeMoney)
                                            .reduce(Money.ZERO, Money::addition);

        this.earningsRate = totalProfitMoney.earningRate(payment);
    }

    public Map<LottoPrize, Integer> getStatisticsMap() {
        return Collections.unmodifiableMap(statisticsMap);
    }

    public double getEarningsRate() {
        return earningsRate;
    }
}
