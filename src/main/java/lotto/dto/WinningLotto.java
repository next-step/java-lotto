package lotto.dto;

import java.util.List;

public class WinningLotto {

    private List<Integer> winnerNums;
    private int bonusNum;

    public WinningLotto(List<Integer> winnerNums, int bonusNum) {
        this.winnerNums = winnerNums;
        this.bonusNum = bonusNum;
    }

    public List<Integer> getWinnerNums() {
        return winnerNums;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
