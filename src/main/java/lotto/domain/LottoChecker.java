package lotto.domain;

import lotto.enums.LottoRank;
import lotto.vo.LottoResult;

public class LottoChecker {
    private LottoChecker() {
    }

    public static LottoResult getResult(Lotto winner, LottoBundle lottoBundle) {
        return new LottoResult(getMatchCounts(winner, lottoBundle));
    }

    static int[] getMatchCounts(Lotto winner, LottoBundle lottoBundle) {
        int[] result = new int[Lotto.TOTAL_LOTTO_NUMBERS + 1];

        lottoBundle.getLottos().forEach(lotto -> {
            int numberOfDuplicatedNumbers = lotto.getNumberOfDuplicatedNumbers(winner);
            result[numberOfDuplicatedNumbers]++;
        });

        return result;
    }

    public static double getTotalProfitRate(long cost, LottoResult lottoResult) {
        return getProfitRate(cost, getTotalPrizeMoney(lottoResult));
    }

    private static double getProfitRate(long money, long totalPrizeMoney) {
        return  (double) totalPrizeMoney / money;
    }

    static long getTotalPrizeMoney(LottoResult lottoResult) {
        long totalPrizeMoney = 0;

        totalPrizeMoney += (LottoRank.FIRST.getPrizeMoney() * lottoResult.getFirst());
        totalPrizeMoney += (LottoRank.SECOND.getPrizeMoney() * lottoResult.getSecond());
        totalPrizeMoney += (LottoRank.THIRD.getPrizeMoney() * lottoResult.getThird());
        totalPrizeMoney += (LottoRank.FOURTH.getPrizeMoney() * lottoResult.getFourth());

        return totalPrizeMoney;
    }
}
