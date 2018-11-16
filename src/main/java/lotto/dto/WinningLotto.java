package lotto.dto;

import java.util.List;

public class WinningLotto extends Lotto {

    private int bonusNum;

    public WinningLotto(List<Integer> winnerNums, int bonusNum) {
        super(winnerNums);
        this.bonusNum = bonusNum;
    }

    public List<Integer> getWinnerNums() {
        return super.getLotto();
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
