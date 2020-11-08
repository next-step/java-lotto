package lotto;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {
    private static final int VALID_MIN_NUMBER = 1;
    private static final int VALID_MAX_NUMBER = 45;
    private static final int VALID_NUMBERS_SIZE = 6;

    private final Set<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = new TreeSet<>(numbers);
        if (this.numbers.size() != VALID_NUMBERS_SIZE) {
            throw new IllegalStateException();
        }
        for (Integer number : numbers) {
            if (number < VALID_MIN_NUMBER) {
                throw new IllegalStateException();
            }

            if (number > VALID_MAX_NUMBER) {
                throw new IllegalStateException();
            }
        }
    }
}
