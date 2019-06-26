package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private int lottoCount;
    private Map<Prize, Integer> statisticsByPrize;

    private LottoResult(Map<Prize, Integer> statisticsByPrize, int lottoCount) {
        this.statisticsByPrize = statisticsByPrize;
        this.lottoCount = lottoCount;
    }

    public static LottoResult of(List<Prize> lottoPrize) {
        Map<Prize, Integer> statisticsByPrize = new EnumMap<>(Prize.class);
        for (Prize prize : lottoPrize) {
            int count = statisticsByPrize.getOrDefault(prize, 0);
            statisticsByPrize.put(prize, ++count);
        }
        return new LottoResult(statisticsByPrize, lottoPrize.size());
    }

    Money calculateTotalBuyMoney() {
        return Money.calculateTotal(lottoCount);
    }

    Money calculateTotalWinningMoney() {
        return statisticsByPrize.keySet()
                .stream()
                .map(this::getPrizeMoney)
                .reduce(Money::plus)
                .orElse(Money.ZERO);
    }

    private Money getPrizeMoney(Prize prize) {
        return prize.getMoney().times(countOfPrize(prize));
    }

    public long countOfPrize(Prize prize) {
        return statisticsByPrize.getOrDefault(prize, 0);
    }
}
