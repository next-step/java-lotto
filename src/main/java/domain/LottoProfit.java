package domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import domain.type.LottoPrice;
import domain.type.LottoRankResult;

public class LottoProfit {
    public static BigDecimal getProfitRate(Lottos lottos, FirstPlaceLotto firstPlaceLotto) {
        List<LottoRankResult> ranks = lottos.getLottos().stream().map(it -> it.calculateLottoRank(firstPlaceLotto))
                .toList();

        return getProfitSum(ranks).divide(buyAmount(lottos), 2, RoundingMode.DOWN);
    }

    public static BigDecimal buyAmount(Lottos lotto) {
        return new BigDecimal(lotto.size() * LottoPrice.PRICE.getPrice());
    }

    public static BigDecimal getProfitSum(List<LottoRankResult> ranks) {
        List<Integer> amounts = ranks.stream().map(it -> it.getAmount().getReward()).toList();

        return getProfitAmountSum(amounts);
    }

    public static BigDecimal getProfitAmountSum(List<Integer> amounts) {
        return new BigDecimal(amounts.stream()
                .reduce(0, Integer::sum));
    }

}
