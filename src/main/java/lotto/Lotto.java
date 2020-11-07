package lotto;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {
    private static final int NUMBERS_SIZE = 6;

    private final Set<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = new TreeSet<>(numbers);
        if (this.numbers.size() != NUMBERS_SIZE) {
            throw new IllegalStateException();
        }
    }
}
