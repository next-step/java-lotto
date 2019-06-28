package lotto.model;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    private Map<Prize, Integer> statisticsByPrize;

    private LottoResult(Map<Prize, Integer> statisticsByPrize) {
        this.statisticsByPrize = statisticsByPrize;
    }

    public static LottoResult of(List<Prize> lottoPrize) {
        Map<Prize, Integer> statisticsByPrize = new EnumMap<>(Prize.class);
        for (Prize prize : lottoPrize) {
            int count = statisticsByPrize.getOrDefault(prize, 0);
            statisticsByPrize.put(prize, ++count);
        }
        return new LottoResult(statisticsByPrize);
    }

    static LottoResult of(Prize... lottoPrize) {
        return of(Arrays.stream(lottoPrize).collect(Collectors.toList()));
    }

    public double getRateOfReturn() {
        return Money.getRateOfReturn(calculateTotalPrizeMoney(), calculateTotalMoney());
    }

    private Money calculateTotalMoney() {
        long countOfBuyLotto = statisticsByPrize.values()
                .stream()
                .reduce(0, Integer::sum);
        return Lotto.PRICE.times(countOfBuyLotto);
    }

    private Money calculateTotalPrizeMoney() {
        return statisticsByPrize.keySet()
                .stream()
                .map(prize -> prize.sumTotalMoney(this.countOfPrize(prize)))
                .reduce(Money.ZERO, Money::sum);
    }

    public long countOfPrize(Prize prize) {
        return statisticsByPrize.getOrDefault(prize, 0);
    }

}