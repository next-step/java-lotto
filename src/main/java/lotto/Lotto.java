package lotto;

import java.util.List;
import java.util.Set;

public class Lotto {

    public static final int PRICE = 1000;
    public static final int NUMBERS_LENGTH = 6;

    private final Set<Integer> numbers;

    public Lotto(Set<Integer> numbers) {
        validation(numbers);
        this.numbers = numbers;
    }

    private void validation(Set<Integer> numbers) {
        if (numbers == null || numbers.size() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }
}
