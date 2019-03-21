package lotto.vo;

import lotto.domain.LottoMachine;
import lotto.enums.LottoRank;

import java.util.Arrays;

public class LottoProfit {
    private final long cost;
    private final long totalPrizeMoney;

    public LottoProfit(LottoWinResult lottoWinResult) {
        this.cost = getCostFromLottoWinResult(lottoWinResult);
        this.totalPrizeMoney = getTotalPrizeMoneyFromLottoWinResult(lottoWinResult);
    }

    private long getCostFromLottoWinResult(LottoWinResult lottoWinResult) {
        long numberOfLottos = getNumberOfLottos(lottoWinResult);
        return LottoMachine.LOTTO_PRICE * numberOfLottos;
    }

    private long getNumberOfLottos(LottoWinResult lottoWinResult) {
        return Arrays.asList(LottoRank.values()).stream()
                .mapToLong(lottoWinResult::getLottoRankCount)
                .sum();
    }

    private long getTotalPrizeMoneyFromLottoWinResult(LottoWinResult lottoWinResult) {
        return Arrays.asList(LottoRank.values()).stream()
                .mapToLong(lottoRank -> lottoRank.getPrizeMoney() * lottoWinResult.getLottoRankCount(lottoRank))
                .sum();
    }

    public long getCost() {
        return this.cost;
    }

    public long getTotalPrizeMoney() {
        return this.totalPrizeMoney;
    }

    public double getTotalProfitRate() {
        return (double) this.totalPrizeMoney / this.cost;
    }
}
