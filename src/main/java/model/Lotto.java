package model;

import java.util.List;

public class Lotto {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private List<Integer> numbers;
    private Prize prize;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        this.prize = null;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Prize getPrize() {
        return prize;
    }

    public void calPrize(List<Integer> winningNumbers) {
        int cnt = (int) winningNumbers.stream()
                .filter(it -> this.numbers.contains(it))
                .count();
        this.prize = Prize.getPrize(cnt);
    }
}
