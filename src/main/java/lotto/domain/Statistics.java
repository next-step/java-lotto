package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Statistics {
    private final WinnerLotto winnerLotto;
    private final List<Lotto> lottoList;
    private Map<Prize, Long> statisticsWinnerMap;

    public Statistics(WinnerLotto winnerLotto, List<Lotto> lottoList) {
        this.winnerLotto = winnerLotto;
        this.lottoList = lottoList;
        this.statisticsWinnerMap = doStatistic();
    }

    public Map<Prize, Long> doStatistic() {
        return lottoList.stream()
                .map(winnerLotto::findMatchingCount)
                .map(Prize::valueOf)
                .filter(prize -> Prize.OUT_OF_PLACE != prize)
                .collect(groupingBy(Function.identity(), Collectors.counting()));
    }

    public Map<Prize, Long> statisticsWinner() {
        return Collections.unmodifiableMap(statisticsWinnerMap);
    }

    public double getProfit(Money money) {

        int sum = getSumProfit(statisticsWinnerMap);

        return Money.wons(sum).division(money);
    }

    private int getSumProfit(Map<Prize, Long> winnerMap) {
        return winnerMap.entrySet()
                .stream()
                .mapToInt(prize -> {
                    Prize profitPrize = prize.getKey();
                    return profitPrize.calculatePriceMoney(profitPrize, Math.toIntExact(prize.getValue()));
                })
                .sum();
    }
}
