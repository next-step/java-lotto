package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoStatistics {

    private static final int LOTTO_PRICE = 1_000;
    private static final int PROFIT_RATE_SCALE = 2;

    private final List<LottoRank> lottoRanks;

    public LottoStatistics(List<LottoRank> lottoRanks) {
        this.lottoRanks = new ArrayList<>(lottoRanks);
    }

    public BigDecimal calculateProfitRate() {
        long profit = calculateProfit();
        int amount = lottoRanks.size() * LOTTO_PRICE;

        return BigDecimal.valueOf(profit)
                .divide(BigDecimal.valueOf(amount), PROFIT_RATE_SCALE, RoundingMode.DOWN);
    }

    public long calculateProfit() {
        return lottoRanks.stream()
                .mapToLong(LottoRank::getReward)
                .sum();
    }

    public Map<LottoRank, Long> getLottoRankCountMap() {
        return lottoRanks.stream()
                .collect(Collectors.groupingBy(lottoRank -> lottoRank, Collectors.counting()));
    }
}
