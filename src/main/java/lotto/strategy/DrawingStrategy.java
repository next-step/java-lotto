package lotto.strategy;

import java.util.Set;
import java.util.stream.Collectors;

public abstract class DrawingStrategy {
    protected final static int NUMBER_COUNT = 6;
    protected final static int THRESHOLD = 45;

    public abstract Set<Integer> drawNumbers();

    protected boolean isInvalid(Set<Integer> numbers) {

        Set<Integer> filteredNumbers = numbers.stream()
                .filter(this::isValidRange)
                .collect(Collectors.toSet());

        return filteredNumbers.size() != NUMBER_COUNT;

    }

    private boolean isValidRange(int number){
        return 0 < number && number <= THRESHOLD;
    }
}
