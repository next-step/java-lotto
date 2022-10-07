package lotto.models;

import java.util.Set;

public class Lotto {

    private final Set<Integer> numbers;

    private Lotto(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public static Lotto of(Set<Integer> numbers) {
        return new Lotto(numbers);
    }
}
