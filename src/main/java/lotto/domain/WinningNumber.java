package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    public final List<Integer> winningNumbers;

    public WinningNumber() {
        winningNumbers = new ArrayList<>();
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
