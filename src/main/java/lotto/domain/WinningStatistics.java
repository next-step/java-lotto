package lotto.domain;

import java.util.List;

public class WinningStatistics {

    private final RankWithWinningCount rankWithWinningCount;
    private final long totalWinningPrize;
    private final int lottoAmount;

    public WinningStatistics(final List<LottoRank> lottoRankResults) {
        this(new RankWithWinningCount(lottoRankResults),
                lottoRankResults.stream().mapToLong(LottoRank::getPrize).sum(),
                lottoRankResults.size());
    }

    private WinningStatistics(
            final RankWithWinningCount rankWithWinningCount,
            final long totalWinningPrize,
            final int lottoAmount
    ) {
        this.rankWithWinningCount = rankWithWinningCount;
        this.totalWinningPrize = totalWinningPrize;
        this.lottoAmount = lottoAmount;
    }

    public int getWinningCount(final LottoRank lottoRank) {
        return this.rankWithWinningCount.getWinningCount(lottoRank);
    }

    public double getEarningRate() {
        return this.totalWinningPrize / (double) (this.lottoAmount * Lotto.PRICE);
    }

    public WinningStatistics sum(WinningStatistics other) {
        return new WinningStatistics(
                this.rankWithWinningCount.sum(other.rankWithWinningCount),
                this.totalWinningPrize + other.totalWinningPrize,
                this.lottoAmount + other.lottoAmount
        );
    }
}
