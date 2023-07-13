package lotto.domain;

import java.util.List;

public class WinningStatistics {

    private final RankWithWinningCount rankWithWinningCount;
    private final double earningRate;

    public WinningStatistics(final List<LottoRank> lottoRankResults) {
        this.rankWithWinningCount = new RankWithWinningCount(lottoRankResults);
        this.earningRate = initEarningRate(lottoRankResults);
    }

    private double initEarningRate(final List<LottoRank> lottoRankResults) {
        return sumLottoResultPrize(lottoRankResults) /
                (double) (lottoRankResults.size() * Lotto.PRICE);
    }

    private long sumLottoResultPrize(final List<LottoRank> lottoResultRanks) {
        return lottoResultRanks.stream()
                .mapToLong(LottoRank::getPrize)
                .sum();
    }

    public int getWinningCount(final LottoRank lottoRank) {
        return this.rankWithWinningCount.getWinningCount(lottoRank);
    }

    public double getEarningRate() {
        return this.earningRate;
    }
}
