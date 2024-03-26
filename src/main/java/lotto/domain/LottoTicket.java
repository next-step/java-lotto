package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private final List<Integer> numbers;

    public LottoTicket(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int winningCount(List<Integer> winningNumbers) {
        return WinningCount.compareNumbers(numbers, winningNumbers);
    }
}
