package lotto.model;

import java.util.Objects;
import java.util.Set;

public class Lotto {
    private final Set<Integer> numbers;

    private Lotto(final Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(final Set<Integer> numbers) {
        Objects.requireNonNull(numbers, "numbers must be not null.");
        return new Lotto(numbers);
    }

    public LottoPrize scratch(final WinningNumber winningNumber) {
        return LottoPrize.findByMatchCount((int) winningNumber.read()
                                                              .stream()
                                                              .filter(numbers::contains)
                                                              .count());
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
