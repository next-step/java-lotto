package lotto.domain;

import lotto.domain.strategy.WinningStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultCalculator {

    private static final int DEFAULT_VALUE = 0;
    private static final double RATIO = 100.0;
    private static final int LOTTO_PRICE = 1000;
    private final List<WinningStrategy> strategies;

    public LottoResultCalculator(List<WinningStrategy> strategies) {
        this.strategies = strategies;
    }

    public Map<String, Integer> calculateResults(Lottos lottos, Lotto winningNumbers) {
        Map<String, Integer> results = new HashMap<>();
        for (WinningStrategy strategy : strategies) {
            results.put(strategy.getResultKey(), DEFAULT_VALUE);
        }

        lottos.getValue().stream()
                .flatMap(lotto -> strategies.stream()
                        .filter(strategy -> strategy.matches(lotto, winningNumbers))
                        .map(WinningStrategy::getResultKey))
                .forEach(key -> results.merge(key, 1, Integer::sum));

        return results;
    }

    public double calculateProfit(Map<String, Integer> results, int lottoCount) {

        double profit = strategies.stream()
                .mapToDouble(strategy -> results.getOrDefault(strategy.getResultKey(), DEFAULT_VALUE) * strategy.getWinningMoney())
                .sum();

        double profitRate = (profit / (lottoCount * LOTTO_PRICE));
        return Math.round(profitRate * RATIO) / RATIO;
    }
}