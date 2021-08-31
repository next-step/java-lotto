package lotto.domain;

import java.util.Map;

public class LottoCalculator {
    private double rateOfReturn;

    public double requestRateOfReturn(Map<LottoRank, Integer> ranks, int buyingCount) {
        rateOfReturn = (double) (LottoRank.FOURTH.getPrizeMoney() * ranks.getOrDefault(LottoRank.FOURTH, 0)
                + LottoRank.THIRD.getPrizeMoney() * ranks.getOrDefault(LottoRank.THIRD, 0)
                + LottoRank.SECOND.getPrizeMoney() * ranks.getOrDefault(LottoRank.SECOND, 0)
                + LottoRank.FIRST.getPrizeMoney() * ranks.getOrDefault(LottoRank.FIRST, 0))
                / (buyingCount * Lotto.PRICE);

        return Math.round(rateOfReturn * 100) / 100.0;
    }
}
