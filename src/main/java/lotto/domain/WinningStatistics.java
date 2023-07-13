package lotto.domain;

import java.util.List;

public class WinningStatistics {

    private final RankWithWinningCount rankWithWinningCount;
    private final double earningRate;

    public WinningStatistics(final List<LottoRule> lottoResults) {
        this.rankWithWinningCount = new RankWithWinningCount(lottoResults);
        this.earningRate =
                sumLottoResultPrize(lottoResults) / (double) (lottoResults.size() * Lotto.PRICE);
    }

    private long sumLottoResultPrize(final List<LottoRule> lottoResults) {
        return lottoResults.stream()
                .mapToLong(LottoRule::getPrize)
                .sum();
    }

    public int getWinningCount(final LottoRule lottoRule) {
        return this.rankWithWinningCount.getWinningCount(lottoRule);
    }

    public double getEarningRate() {
        return this.earningRate;
    }
}
