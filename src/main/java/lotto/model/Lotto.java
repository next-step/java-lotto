package lotto.model;

import lotto.strategy.DrawingStrategy;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public abstract class Lotto {
    public final static int PRICE = 1000;
    protected SortedSet<Integer> numbers;

    public Lotto(DrawingStrategy drawingStrategy) {
        numbers = drawingStrategy.drawNumbers();
    }

    public SortedSet<Integer> getMatchingNumberCount(SortedSet<Integer> inputNumbers, int bonus) {
        SortedSet<Integer> matchNumbers = numbers.stream()
                .filter(inputNumbers::contains)
                .collect(Collectors.toCollection(TreeSet::new));

        if(inputNumbers.contains(bonus)){
            matchNumbers.add(bonus);
        }

        return matchNumbers;
    }

    public SortedSet<Integer> getNumbers() {
        return numbers;
    }

}
