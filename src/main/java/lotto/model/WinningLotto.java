package lotto.model;

import lotto.strategy.DrawingStrategy;

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

        return Math.floor(((double) totalReword / amount) * 100) / 100;
    }


    private int calculateReword(Map.Entry<Hit, Integer> e) {
        return e.getKey().calculateReword(e.getValue());
    }

    @Override
    public SortedSet<Integer> getNumbers() {
        return null;
    }
}

