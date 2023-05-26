package domain;

import java.util.List;
import java.util.Set;

public class WinningNumbers {

    private Set<Integer> winningNumbers;

    public WinningNumbers(Set<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public boolean contains(int count) {
        return winningNumbers.contains(count);
    }
}
