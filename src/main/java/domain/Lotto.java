package domain;

import java.util.*;

public class Lotto {
    private List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        Objects.requireNonNull(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public LottoPrize checkWhetherToWin(List<Integer> winningNumbers) {
        int count = (int) winningNumbers.stream()
                .filter(numbers::contains)
                .count();

        return LottoPrize.of(count);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
