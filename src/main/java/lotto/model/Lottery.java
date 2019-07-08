package lotto.model;

import java.util.LinkedHashSet;
import java.util.Set;

public class Lottery {

    private LinkedHashSet<Number> numbers;

    public Lottery(LinkedHashSet<Number> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(LinkedHashSet<Number> numbers) {
        if (!hasSixNumbers(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasSixNumbers(LinkedHashSet<Number> numbers) {
        return numbers.size() == 6;
    }

    public int getWinningCount(LinkedHashSet<Number> winningNumbers) {

        int count = (int) winningNumbers.stream()
                .filter(winningNumber -> numbers.stream().map(Number::getNumber).anyMatch(e -> e == winningNumber.getNumber()))
                .count();

        return count;
    }

    public Set<Number> getNumbers() {
        return numbers;
    }
}
