package lotto.domain;

import java.util.Map;

public class LottoResult {
    private Map<LottoRank, Integer> ranks;

    public LottoResult(Map<LottoRank, Integer> ranks) {
        this.ranks = ranks;
    }

    public double requestRateOfReturn(int buyingCount) {
        double rateOfReturn = (double) (LottoRank.FOURTH.getPrizeMoney() * ranks.getOrDefault(LottoRank.FOURTH, 0)
                + LottoRank.THIRD.getPrizeMoney() * ranks.getOrDefault(LottoRank.THIRD, 0)
                + LottoRank.SECOND.getPrizeMoney() * ranks.getOrDefault(LottoRank.SECOND, 0)
                + LottoRank.FIRST.getPrizeMoney() * ranks.getOrDefault(LottoRank.FIRST, 0))
                / (buyingCount * Lotto.PRICE);

        return Math.round(rateOfReturn * 100) / 100.0;
    }

    public int getMatchCount(LottoRank rank) {
        return ranks.getOrDefault(rank,0);
    }
}
