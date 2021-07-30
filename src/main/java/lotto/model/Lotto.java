package lotto.model;

import java.util.Objects;
import java.util.Set;

public class Lotto {
    private static final int NUMBER_OF_LOTTO_COUNT = 6;

    private final Set<Integer> numbers;

    private Lotto(final Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(final Set<Integer> numbers) {
        Objects.requireNonNull(numbers, "numbers must be not null.");
        return new Lotto(numbers);
    }

    public LottoPrize scratch(final WinningLotto winningLotto) {
        Objects.requireNonNull(winningLotto, "winningLotto must be not null.");
        return LottoPrize.findByMatchCount(winningLotto.matchCount(this));
    }

    public boolean isSizeValid() {
        return numbers.size() == NUMBER_OF_LOTTO_COUNT;
    }

    public int matchCount(Lotto winningLotto) {
        return (int) winningLotto.numbers.stream()
                                         .filter(numbers::contains)
                                         .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
