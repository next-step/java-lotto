package lotto.service;

import lotto.domain.LottoRank;
import lotto.dto.LottoStatistics;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class LottoStatisticsService {

    private static final int LOTTO_PRICE = 1_000;
    private static final int PROFIT_RATE_SCALE = 2;

    public LottoStatistics create(List<LottoRank> lottoRanks) {
        long profit = calculateProfit(lottoRanks);
        BigDecimal profitRate = calculateProfitRate(lottoRanks.size(), profit);

        return LottoStatistics.of(profitRate, lottoRanks);
    }

    public BigDecimal calculateProfitRate(int count, long profit) {
        int amount = count * LOTTO_PRICE;

        return BigDecimal.valueOf(profit)
                .divide(BigDecimal.valueOf(amount), PROFIT_RATE_SCALE, RoundingMode.DOWN);
    }

    public long calculateProfit(List<LottoRank> lottoRanks) {
        return lottoRanks.stream()
                .mapToLong(LottoRank::getReward)
                .sum();
    }
}
