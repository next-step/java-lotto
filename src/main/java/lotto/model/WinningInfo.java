package lotto.model;

import java.util.List;

public class WinningInfo {

    private List<Integer> winningLotto;
    private int bonusNumber;

    public WinningInfo(List<Integer> winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }
}
