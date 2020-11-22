package lotto.model;

import lotto.strategy.DrawingStrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

public class WinningLotto extends Lotto {

    public WinningLotto(DrawingStrategy drawingStrategy) {
        super(drawingStrategy);
    }

    public Map<Hit, Integer> getResult(List<SortedSet<Integer>> numbers) {
        Map<Hit, Integer> hits = Hit.getHits();
        numbers.stream()
                .map(this::getMatchingNumberCount)
                .map(Hit::findByHitCount)
                .forEach(hit -> hits.computeIfPresent(hit, (Hit key, Integer value) -> ++value));
        return hits;
    }


    public double getEarningRate(int amount, List<SortedSet<Integer>> numbers) {
        int totalReword = getResult(numbers).entrySet().stream()
                .mapToInt(this::calculateReword)
                .sum();

        BigDecimal safeReword = BigDecimal.valueOf((double) totalReword);
        BigDecimal safeAmount = BigDecimal.valueOf(amount);

        return safeReword.divide(safeAmount,2, RoundingMode.FLOOR)
                .doubleValue();
    }


    private int calculateReword(Map.Entry<Hit, Integer> hits) {
        return hits.getKey().calculateReword(hits.getValue());
    }

    @Override
    public SortedSet<Integer> getNumbers() {
        return null;
    }
}

