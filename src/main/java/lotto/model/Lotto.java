package lotto.model;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> numbers;
    private LottoPrize lottoPrize;

    private Lotto(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(final List<Integer> numbers) {
        Objects.requireNonNull(numbers, "numbers must be not null.");
        return new Lotto(numbers);
    }

    public void scratch(final WinningNumber winningNumber) {
        long matchCount = winningNumber.read().stream().filter(numbers::contains).count();
        lottoPrize = LottoPrize.findByMatchCount((int) matchCount);
    }

    public int matchCount() {
        Objects.requireNonNull(lottoPrize, "you must scratch the lottery ticket first.");
        return lottoPrize.getMatchCount();
    }

    public int prize() {
        Objects.requireNonNull(lottoPrize, "you must scratch the lottery ticket first.");
        return lottoPrize.getPrizeMoney();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
