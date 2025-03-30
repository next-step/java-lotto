package lotto;

import java.util.List;

public class LottoTicket {
    public static final int PRICE = 1000;

    private final Game numbers;

    public LottoTicket(List<Integer> numbers) {
        this.numbers = new Game(numbers);
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
