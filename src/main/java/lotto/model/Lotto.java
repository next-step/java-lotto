package lotto.model;

import lotto.strategy.DrawingStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final static int NUMBER_COUNT = 6;
    public final static int PRICE = 1000;

    private List<Integer> numbers;

    public Lotto(DrawingStrategy drawingStrategy){
        numbers = drawingStrategy.drawNumbers(NUMBER_COUNT);
    }

    public List<Integer> getMatchingNumbers(List<Integer> winnerNumbers){
        return numbers.stream()
                .filter(winnerNumbers::contains)
                .collect(Collectors.toList());
    }
}
