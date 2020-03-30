package lotto;

import java.util.HashSet;
import java.util.Set;

public class Numbers {
    private final Set<Integer> numbers;

    public Numbers(Set<Integer> numbers) {
        this.numbers = new HashSet<>(numbers);
    }

    public Set<Integer> getNumbers() {
        return new HashSet<>(numbers);
    }
}
