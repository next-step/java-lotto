package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {

    private static final int DRAW_NUMBER = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if (isInvalidNumbers(numbers)) {
            throw new IllegalArgumentException();
        }
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private static boolean isInvalidNumbers(List<Integer> numbers) {
        return numbers == null || numbers.size() != DRAW_NUMBER || numbers.stream().anyMatch(
            Objects::isNull);
    }

}
