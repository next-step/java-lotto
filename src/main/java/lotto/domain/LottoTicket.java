package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    private final List<Integer> numbers;
    private WinningCount winningCount;

    public LottoTicket(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
        this.winningCount = new WinningCount();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void compareWithWinningNumbers(List<Integer> winningNumbers) {
        this.winningCount.compareNumbers(this.numbers, winningNumbers);
    }

    public int getWinningCount() {
        return this.winningCount.getCount();
    }
}
