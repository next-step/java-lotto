package model;

import java.util.List;
import java.util.Objects;

public class Lotto {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private List<Integer> numbers;
    private Prize prize;

    public Lotto(List<Integer> numbers) {
        this(numbers, null, null);
    }

    public Lotto(List<Integer> numbers, List<Integer> winningNumbers) {
        this(numbers, winningNumbers, null);
    }

    public Lotto(List<Integer> numbers, List<Integer> winningNumbers, Integer bonus) {
        this.numbers = numbers;
        calPrize(winningNumbers, bonus);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Prize getPrize() {
        return prize;
    }

    public void calPrize(List<Integer> winningNumbers, Integer bonus) {
        if (winningNumbers == null || winningNumbers.isEmpty()) {
            return;
        }
        int cnt = (int) winningNumbers.stream()
                .filter(it -> this.numbers.contains(it))
                .count();
        this.prize = Prize.getPrize(cnt, isBonusMatched(bonus));
    }

    private boolean isBonusMatched(Integer bonus) {
        if (bonus == null) {
            return false;
        }
        return this.numbers.stream()
                .anyMatch(it -> Objects.equals(it, bonus));
    }
}
