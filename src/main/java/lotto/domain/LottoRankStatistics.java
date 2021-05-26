package lotto.domain;

import java.util.Map;
import java.util.HashMap;

import lotto.constant.LottoRank;

public class LottoRankStatistics {
    private static final int DEFAULT_COUNT = 0;
    private static final long DEFAULT_MONEY = 0L;
    private static final int ONE_HUNDRED_INT = 100;
    private static final double ONE_HUNDRED_DOUBLE = 100.0;
    private final Lottos lottos;
    private final LottoNumbers winningNumbers;
    private final LottoNumber bonusNumber;
    private RankCounts rankCounts;

    public LottoRankStatistics(Lottos lottos, LottoNumbers winningNumber, LottoNumber bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public void initStatistics() {
        Map<LottoRank, Integer> result = new HashMap<>();
        for (int i = 0; i < this.lottos.getSize(); i++) {
            LottoRank lottoRank = findRankByLottoNumbers(this.lottos.getLottoNumbers(i));
            int lottoCount = result.getOrDefault(lottoRank, DEFAULT_COUNT);
            result.put(lottoRank, ++lottoCount);
        }
        this.rankCounts = new RankCounts(result);
    }

    public int getLottoCountByRank(LottoRank rank) {
        return this.rankCounts.getWinningLottoCount(rank);
    }

    public String calculateRateOfReturn() {
        double rateOfReturn = Math.floor(((double) sumTotalWinningAmount()
                / (double) (this.rankCounts.calculateTotalCountByRank() * 1000)) * ONE_HUNDRED_INT)
                / ONE_HUNDRED_DOUBLE;
        return String.format("%.2f", rateOfReturn);
    }

    private LottoRank findRankByLottoNumbers(LottoNumbers lottoNumbers) {
        int matchCount = lottoNumbers.getCountOfMatchingNumber(this.winningNumbers);
        boolean resultBonus = lottoNumbers.contains(this.bonusNumber);
        return LottoRank.valueOf(matchCount, resultBonus);
    }

    private long sumTotalWinningAmount() {
        long totalAmount = DEFAULT_MONEY;
        for (LottoRank rank : LottoRank.values()) {
            totalAmount += this.rankCounts.getWinningLottoCount(rank) * rank.getWinningMoney();
        }
        return totalAmount;
    }
}
