package autolotto.machine.winning;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = new ArrayList<>(winningNumbers);
    }

    public List<Integer> winningNumbers() {
        return new ArrayList<>(this.winningNumbers);
    }
}
