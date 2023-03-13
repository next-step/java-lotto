package domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import domain.type.LottoBonusState;
import domain.type.LottoPrice;
import domain.type.LottoRankAmount;

public class LottoProfit {
    public static BigDecimal getProfitRate(Lottos lottos) {
        List<LottoRankAmount> ranks = new ArrayList<>();
        lottos.getLottos().forEach(it -> ranks.add(it.getLottoRankAmount()));

        return getProfitSum(ranks).divide(new BigDecimal(lottos.size() * LottoPrice.PRICE.getPrice()));
    }

    public static BigDecimal getProfitSum(List<LottoRankAmount> ranks) {
        List<Integer> amounts = new ArrayList<>();
        ranks.forEach(it -> amounts.add(it.getAmount().getReward()));

        return getProfitAmountSum(amounts);
    }

    public static BigDecimal getProfitAmountSum(List<Integer> amounts) {
        return new BigDecimal(amounts.stream()
                .reduce(0, Integer::sum));
    }

}
