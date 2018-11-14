package lotto.model;

import java.util.HashSet;
import java.util.Set;

public class Lotto {
    private Set<Integer> numbers;

    public Lotto(Set<Integer> numbers) {
        this.numbers = new HashSet<>(numbers);
    }

    public int getMatchCount(Set<Integer> targetNumbers) {
        return (int) targetNumbers.stream()
                .filter(targetNumber -> this.numbers.contains(targetNumber))
                .count();
    }
}
