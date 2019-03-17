package lotto.domain;

import lotto.enums.LottoRank;
import lotto.vo.LottoResult;

public class LottoProfitCalculator {
    private LottoProfitCalculator() {
    }

    public static double getTotalProfitRate(long cost, LottoResult lottoResult) {
        return getProfitRate(cost, getTotalPrizeMoney(lottoResult));
    }

    static long getTotalPrizeMoney(LottoResult lottoResult) {
        long totalPrizeMoney = 0;

        totalPrizeMoney += (LottoRank.FIRST.getPrizeMoney() * lottoResult.getFirst());
        totalPrizeMoney += (LottoRank.SECOND.getPrizeMoney() * lottoResult.getSecond());
        totalPrizeMoney += (LottoRank.THIRD.getPrizeMoney() * lottoResult.getThird());
        totalPrizeMoney += (LottoRank.FOURTH.getPrizeMoney() * lottoResult.getFourth());

        return totalPrizeMoney;
    }

    private static double getProfitRate(long cost, long profit) {
        return (double) profit / cost;
    }
}
