package lotto.strategy;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public abstract class DrawingStrategy {
    protected final static int THRESHOLD = 45;

    public abstract List<Integer> drawNumbers(int numbersCount);

    protected boolean isInvalid(List<Integer> numbers, int numberCount) {

        List<Integer> filteredNumbers = numbers.stream()
                .filter(this::isValidRange)
                .collect(Collectors.toList());

        return (new HashSet<>(filteredNumbers).size()) != numberCount;

    }

    private boolean isValidRange(int number){
        return 0 < number && number <= THRESHOLD;
    }
}
