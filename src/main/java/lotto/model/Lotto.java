package lotto.model;

import lotto.strategy.DrawingStrategy;

import java.util.Set;

public abstract class Lotto {
    public final static int PRICE = 1000;
    protected Set<Integer> numbers;

    public Lotto(DrawingStrategy drawingStrategy) {
        numbers = drawingStrategy.drawNumbers();
    }

    public int getMatchingNumberCount(Set<Integer> inputNumbers) {
        return numbers.stream()
                .filter(inputNumbers::contains)
                .toArray()
                .length;
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

}
