package lotto.dto;

import lotto.domain.Win;

import java.util.List;

public class CheckWinningRequest {
    private List<Integer> winningNumbers;
    private int bonusBall;

    public CheckWinningRequest(List<Integer> winningNumbers, int bonusBall) {
        this.winningNumbers = winningNumbers;
        this.bonusBall = bonusBall;
    }


    public Win toWin() {
        return new Win(winningNumbers, bonusBall);
    }

}
