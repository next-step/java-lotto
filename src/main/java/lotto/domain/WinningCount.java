package lotto.domain;

import java.util.List;

public class WinningCount {
    private int count = 0;

    public void addMatch() {
        this.count++;
    }

    public int getCount() {
        return count;
    }

    public void compareNumbers(List<Integer> ticketNumbers, List<Integer> winningNumbers) {
        for (Integer number : ticketNumbers) {
            if (winningNumbers.contains(number)) {
                addMatch();
            }
        }
    }
}
