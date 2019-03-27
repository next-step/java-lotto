package lotto.dto;

import java.util.List;

public class WinningLotto {
    private List<Integer> winningLotto;

    public WinningLotto(List<Integer> winningLotto) {
        this.winningLotto = winningLotto;
    }

    public List<Integer> getWinningLotto() {
        return winningLotto;
    }
}
