package model;

import java.util.List;

public class Lotto {
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

    public Lotto getMatched(List<Integer> winningNumbers) {
        int cnt = 0;
        for (Integer elem : winningNumbers) {
            if (this.numbers.contains(elem)) {
                cnt++;
            }
        }

        this.prize = Prize.getPrize(cnt);
        return this;
    }
}
