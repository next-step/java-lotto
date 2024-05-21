package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final List<Integer> lastWinningNumbers;

    public WinningLotto(Integer... lastWinningNumbers) {
        this(List.of(lastWinningNumbers));
    }

    public WinningLotto(List<Integer> lastWinningNumbers){
        this.lastWinningNumbers = lastWinningNumbers;
    }

    public List<Integer> lastWinningNumbers() {
        return lastWinningNumbers;
    }
}
