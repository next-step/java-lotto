package lotto.model;

import lotto.strategy.DrawingStrategy;

import java.util.List;


public class Lotto {
    private final static int NUMBER_COUNT = 6;
    public final static int PRICE = 1000;

    private List<Integer> numbers;

    public Lotto(DrawingStrategy drawingStrategy) {
        numbers = drawingStrategy.drawNumbers(NUMBER_COUNT);
    }

    public int getMatchingNumberCount(List<Integer> winnerNumbers) {
        return numbers.stream()
                .filter(winnerNumbers::contains)
                .toArray()
                .length;

    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
