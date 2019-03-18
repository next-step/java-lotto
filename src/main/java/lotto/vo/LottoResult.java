package lotto.vo;

import lotto.domain.LottoMachine;
import lotto.enums.LottoRank;

import java.util.Arrays;

public class LottoResult {
    private final LottoWinResult lottoWinResult;
    private final long cost;

    public LottoResult(long[] matchCounts) {
        this.lottoWinResult = new LottoWinResult(matchCounts);
        this.cost = extractCost(matchCounts);
    }

    private long extractCost(long[] matchCounts) {
        return LottoMachine.LOTTO_PRICE * extractNumberOfLottos(matchCounts);
    }

    private long extractNumberOfLottos(long[] matchCounts) {
        return Arrays.stream(matchCounts).sum();
    }

    public long getNumberOfWin(LottoRank lottoRank) {
        return lottoWinResult.get(lottoRank);
    }

    long getCost() {
        return this.cost;
    }

    public long getTotalPrizeMoney() {
        return Arrays.stream(LottoRank.values())
                .mapToLong(lottoRank -> getPrizeMoneyOfLottoRank(lottoWinResult, lottoRank))
                .sum();
    }

    private long getPrizeMoneyOfLottoRank(LottoWinResult lottoWinResult, LottoRank lottoRank) {
        return lottoWinResult.get(lottoRank) * lottoRank.getPrizeMoney();
    }

    public double getTotalProfitRate() {
        return (double) getTotalPrizeMoney() / this.cost;
    }
}
