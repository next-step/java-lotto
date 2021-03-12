package lotto.dto;

import java.util.List;

public class WinningLotteryNumbersRequest {

    private List<Integer> lastWinningLotteryNumbers;

    private int bonusNumber;

    public WinningLotteryNumbersRequest(List<Integer> lastWinningLotteryNumbers, int bonusNumber) {
        this.lastWinningLotteryNumbers = lastWinningLotteryNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getLastWinningLotteryNumbers() {
        return lastWinningLotteryNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
