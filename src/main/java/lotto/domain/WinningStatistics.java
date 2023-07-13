package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {

    private static final int DEFAULT_COUNT = 0;

    private final Map<LottoRule, Integer> rankWithCount;
    private final double earningRate;

    public WinningStatistics(final List<LottoRule> lottoResults) {
        this.rankWithCount = initRankWithCount(lottoResults);
        this.earningRate =
                sumLottoResultPrize(lottoResults) / (double) (lottoResults.size() * Lotto.PRICE);
    }

    private Map<LottoRule, Integer> initRankWithCount(final List<LottoRule> lottoResults) {
        final Map<LottoRule, Integer> rankWithCount = new HashMap<>();

        for (LottoRule lottoResult : lottoResults) {
            rankWithCount.put(lottoResult,
                    rankWithCount.getOrDefault(lottoResult, DEFAULT_COUNT) + 1);
        }

        return rankWithCount;
    }

    private long sumLottoResultPrize(final List<LottoRule> lottoResults) {
        return lottoResults.stream()
                .mapToLong(LottoRule::getPrize)
                .sum();
    }

    public int getWinningCount(final LottoRule lottoRule) {
        return this.rankWithCount.getOrDefault(lottoRule, DEFAULT_COUNT);
    }

    public double getEarningRate() {
        return this.earningRate;
    }
}
