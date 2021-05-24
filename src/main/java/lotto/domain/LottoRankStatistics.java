package lotto.domain;

import java.util.HashMap;
import java.util.Map;

import lotto.constant.LottoRank;

public class LottoRankStatistics {
    private static final int DEFAULT_COUNT = 0;
    private static final long DEFAULT_MONEY = 0L;
    private static final int ONE_HUNDRED_INT = 100;
    private static final double ONE_HUNDRED_DOUBLE = 100.0;
    private final Lottos lottos;
    private final LottoNumbers winningNumbers;
    private RankCounts rankCounts;

    public LottoRankStatistics(Lottos lottos, LottoNumbers winningNumbers) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
    }

    public void initStatistics() {
        Map<LottoRank, Integer> result = new HashMap<>();
        for (int i = 0; i < this.lottos.getSize(); i++) {
            int matchCount = this.lottos.getLotto(i).getCountOfMatchingNumber(this.winningNumbers);
            LottoRank lottoRank = LottoRank.valueOf(matchCount);
            int lottoCount = result.getOrDefault(lottoRank, DEFAULT_COUNT);
            result.put(lottoRank, ++lottoCount);
        }
        this.rankCounts = new RankCounts(result);
    }

    public int getLottoCountByRank(LottoRank rank) {
        return this.rankCounts.getWinningLottoCount(rank);
    }

    public String calculateRateOfReturn() {
        double rateOfReturn = Math.floor(((double) getTotalWinningAmount()
                / (double) (this.rankCounts.calculateTotalCountByRank() * 1000)) * ONE_HUNDRED_INT)
                / ONE_HUNDRED_DOUBLE;
        return String.format("%.2f", rateOfReturn);
    }

    private long getTotalWinningAmount() {
        long totalAmount = DEFAULT_MONEY;
        for (LottoRank rank : LottoRank.values()) {
            totalAmount += this.rankCounts.getWinningLottoCount(rank) * rank.getWinningMoney();
        }
        return totalAmount;
    }
}
