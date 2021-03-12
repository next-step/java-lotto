package lotto.dto;

import java.util.List;

public class WinningLotteryNumbersRequest {

    List<Integer> lastWinningLotteryNumbers;

    public WinningLotteryNumbersRequest(List<Integer> lastWinningLotteryNumbers) {
        this.lastWinningLotteryNumbers = lastWinningLotteryNumbers;
    }

    public List<Integer> getLastWinningLotteryNumbers() {
        return lastWinningLotteryNumbers;
    }
}
