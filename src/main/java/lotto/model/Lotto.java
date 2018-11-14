package lotto.model;

import java.util.HashSet;
import java.util.Set;

public class Lotto {
    private Set<Integer> numbers;

    public Lotto(Set<Integer> numbers) {
        this.numbers = new HashSet<>(numbers);
    }

    public int getMatchCount(Set<Integer> targetNumbers) {
        int count = 0;
        for (int targetNumber : targetNumbers) {
            if (this.numbers.contains(targetNumber)) {
                count++;
            }
        }
        return count;
    }
}
