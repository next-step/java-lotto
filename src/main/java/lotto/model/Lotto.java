package lotto.model;

import lotto.strategy.DrawingStrategy;

import java.util.Set;


public class Lotto {

    public final static int PRICE = 1000;

    private Set<Integer> numbers;

    public Lotto(DrawingStrategy drawingStrategy) {
        numbers = drawingStrategy.drawNumbers();
    }

    public int getMatchingNumberCount(Set<Integer> winnerNumbers) {
        return numbers.stream()
                .filter(winnerNumbers::contains)
                .toArray()
                .length;

    }

    public Set<Integer> getNumbers() {
        return numbers;
    }
}
