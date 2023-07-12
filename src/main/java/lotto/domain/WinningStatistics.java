package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {

    private static final int DEFAULT_COUNT = 0;

    private final Map<Integer, Integer> rankWithCount;
    private final double earningRate;

    public WinningStatistics(final List<LottoResult> lottoResults) {
        this.rankWithCount = initRankWithCount(lottoResults);
        this.earningRate =
                sumLottoResultPrize(lottoResults) / (double) (lottoResults.size() * Lotto.PRICE);
    }

    private Map<Integer, Integer> initRankWithCount(final List<LottoResult> lottoResults) {
        final Map<Integer, Integer> rankWithCount = new HashMap<>();

        for (LottoRule lottoRule : LottoRule.values()) {
            rankWithCount.put(lottoRule.getRank(), DEFAULT_COUNT);
        }
        for (LottoResult lottoResult : lottoResults) {
            int rank = lottoResult.getRank();
            rankWithCount.put(rank, rankWithCount.getOrDefault(rank, DEFAULT_COUNT) + 1);
        }

        return rankWithCount;
    }

    private long sumLottoResultPrize(final List<LottoResult> lottoResults) {
        return lottoResults.stream()
                .mapToLong(LottoResult::getPrize)
                .sum();
    }

    public int getWinningCount(final LottoRule lottoRule) {
        return this.rankWithCount.get(lottoRule.getRank());
    }

    public double getEarningRate() {
        return this.earningRate;
    }
}
