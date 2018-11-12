package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private List<Integer> winningNumbers;

    public WinningLotto() {
        winningNumbers = new ArrayList<>();
    }

    public WinningLotto(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
