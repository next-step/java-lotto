package lotto.vo;

import lotto.domain.LottoMachine;
import lotto.enums.LottoRank;

import java.util.Arrays;

public class LottoProfit {
    private final Money cost;
    private final Money totalPrizeMoney;

    public LottoProfit(LottoWinResult lottoWinResult) {
        this.cost = getCostFromLottoWinResult(lottoWinResult);
        this.totalPrizeMoney = getTotalPrizeMoneyFromLottoWinResult(lottoWinResult);
    }

    private Money getCostFromLottoWinResult(LottoWinResult lottoWinResult) {
        long numberOfLottos = getNumberOfLottos(lottoWinResult);
        long costAmount = LottoMachine.LOTTO_PRICE .getAmount()* numberOfLottos;

        return new Money(costAmount);
    }

    private long getNumberOfLottos(LottoWinResult lottoWinResult) {
        return Arrays.asList(LottoRank.values()).stream()
                .mapToLong(lottoWinResult::getLottoRankCount)
                .sum();
    }

    private Money getTotalPrizeMoneyFromLottoWinResult(LottoWinResult lottoWinResult) {
        long totalPrizeMoneyAmount = Arrays.asList(LottoRank.values()).stream()
                .mapToLong(lottoRank -> lottoRank.getPrizeMoney() * lottoWinResult.getLottoRankCount(lottoRank))
                .sum();

        return new Money(totalPrizeMoneyAmount);
    }

    long getCost() {
        return cost.getAmount();
    }

    long getTotalPrizeMoney() {
        return totalPrizeMoney.getAmount();
    }

    double getTotalProfitRate() {
        return (double) this.totalPrizeMoney.getAmount() / this.cost.getAmount();
    }
}
