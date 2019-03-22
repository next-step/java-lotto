package lotto.vo;

import lotto.domain.LottoMachine;
import lotto.enums.LottoRank;

import java.util.Arrays;

public class LottoProfit {
    private final Money cost;
    private final Money totalPrizeMoney;

    public LottoProfit(LottoWinResult lottoWinResult) {
        this.cost = getCostFromLottoWinResult(lottoWinResult);
        this.totalPrizeMoney = getTotalPrizeMoneyOf(lottoWinResult);
    }

    private Money getCostFromLottoWinResult(LottoWinResult lottoWinResult) {
        long numberOfLottos = getNumberOfLottos(lottoWinResult);
        long costAmount = LottoMachine.LOTTO_PRICE .getAmount()* numberOfLottos;

        return new Money(costAmount);
    }

    private long getNumberOfLottos(LottoWinResult lottoWinResult) {
        return Arrays.asList(LottoRank.values()).stream()
                .mapToLong(lottoWinResult::getLottoRankCountOf)
                .sum();
    }

    private Money getTotalPrizeMoneyOf(LottoWinResult lottoWinResult) {
        long totalPrizeMoneyAmount = Arrays.asList(LottoRank.values()).stream()
                .map(lottoRank -> {
                    long lottoRankCount = lottoWinResult.getLottoRankCountOf(lottoRank);
                    return lottoRank.getTotalPrizeMoneyOfLottoRank(lottoRankCount);
                })
                .mapToLong(Money::getAmount)
                .sum();

        return new Money(totalPrizeMoneyAmount);
    }

    public Money getCost() {
        return cost;
    }

    public Money getTotalPrizeMoney() {
        return totalPrizeMoney;
    }

    public double getTotalProfitRate() {
        return (double) this.totalPrizeMoney.getAmount() / this.cost.getAmount();
    }
}
