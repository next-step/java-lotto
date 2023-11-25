package camp.nextstep.edu.lottery;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lottery {

    public static final int NUMBERS_COUNT = 6;

    private final List<Integer> numbers;

    public Lottery(List<Integer> numbers) {
        if (!isValid(numbers)) {
            throw new IllegalArgumentException();
        }

        this.numbers = numbers;
    }

    public int calcMatchingCount(Lottery that) {
        Set<Integer> thisSet = new HashSet<>(this.numbers);
        Set<Integer> thatSet = new HashSet<>(that.numbers);

        thisSet.retainAll(thatSet);
        return thisSet.size();
    }

    private boolean isValid(List<Integer> numbers) {
        boolean isEmpty = numbers == null || numbers.isEmpty();
        if (isEmpty) {
            return false;
        }

        boolean is6Size = numbers.size() == NUMBERS_COUNT;
        return is6Size && !isDuplicated(numbers) && isBetween1And45(numbers);
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return numbers.stream().distinct().count() != 6;
    }

    private boolean isBetween1And45(List<Integer> numbers) {
        boolean result = true;
        for (int number : numbers) {
            result &= isBetween1And45(number);
        }
        return result;
    }

    private boolean isBetween1And45(int number) {
        return number >= 1 && number <= 45;
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
