package lotto.util;

import lotto.domain.Ranking;

import java.util.Map;

public class YieldCalculator {

    private YieldCalculator() {
    }

    public static double calculate(Map<Ranking, Integer> winningMap, int price) {
        return winningMap.keySet()
                .stream().map(ranking -> ranking.getPriceByCount(winningMap.get(ranking)))
                .mapToInt(i -> i)
                .sum() / (double) price;
    }
}
