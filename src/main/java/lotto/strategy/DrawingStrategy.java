package lotto.strategy;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public abstract class DrawingStrategy {
    protected final static int NUMBER_COUNT = 6;
    protected final static int THRESHOLD = 45;

    public abstract SortedSet<Integer> drawNumbers();

    protected boolean isInvalid(SortedSet<Integer> numbers) {

        SortedSet<Integer> filteredNumbers = numbers.stream()
                .filter(this::isValidRange)
                .collect(Collectors.toCollection(TreeSet::new));

        return filteredNumbers.size() != NUMBER_COUNT;

    }

    private boolean isValidRange(int number){
        return 0 < number && number <= THRESHOLD;
    }
}
