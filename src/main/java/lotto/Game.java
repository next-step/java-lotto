package lotto;

import java.util.List;

public class Game {

    private final LottoNumbers numbers;

    public Game(List<Integer> numbers) {
        this.numbers = new LottoNumbers(numbers);
    }

    public int countMatches(List<Integer> winningNumbers) {
        return numbers.countMatches(winningNumbers);
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.hasBonusNumber(bonusNumber);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
