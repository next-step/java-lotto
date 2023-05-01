package lotto.dto;

import java.util.List;

public class CheckWinningRequest {
    private List<Integer> winningNumbers;
    private int bonusBall;

    public CheckWinningRequest(List<Integer> winningNumbers, int bonusBall) {
        this.winningNumbers = winningNumbers;
        this.bonusBall = bonusBall;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusBall() {
        return bonusBall;
    }
}
