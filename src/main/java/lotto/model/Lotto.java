package lotto.model;

import lotto.strategy.DrawingStrategy;

import java.util.SortedSet;

public abstract class Lotto {
    public final static int PRICE = 1000;
    protected SortedSet<Integer> numbers;

    public Lotto(DrawingStrategy drawingStrategy) {
        numbers = drawingStrategy.drawNumbers();
    }

    public int getMatchingNumberCount(SortedSet<Integer> inputNumbers) {
        return numbers.stream()
                .filter(inputNumbers::contains)
                .toArray()
                .length;
    }

    public SortedSet<Integer> getNumbers() {
        return numbers;
    }

}
