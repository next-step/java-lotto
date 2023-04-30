package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Statistics {
    private final WinnerLotto winnerLotto;


    public Statistics(WinnerLotto winnerLotto) {
        this.winnerLotto = winnerLotto;
    }

    public Map<Prize, Long> statisticsWinner(List<Lotto> lottoList) {

        return lottoList.stream()
                .map(winnerLotto::findMatchingCount)
                .map(Prize::valueOf)
                .collect(groupingBy(Function.identity(), Collectors.counting()));
    }

    public double getProfit(Money money, List<Lotto> lottoList) {
        Map<Prize, Long> winnerMap = statisticsWinner(lottoList);

        int sum = getSumProfit(winnerMap);

        return Money.wons(sum).division(money);
    }

    private int getSumProfit(Map<Prize, Long> winnerMap) {
        return winnerMap.entrySet()
                .stream()
                .mapToInt(prize -> Prize.calculatePriceMoney(prize.getKey(), Math.toIntExact(prize.getValue())))
                .sum();
    }
}
