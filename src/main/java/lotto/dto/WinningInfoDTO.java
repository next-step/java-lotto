package lotto.dto;

import lotto.domain.WinningAmount;

public class WinningInfoDTO {
    private int correctCount;
    private WinningAmount winningAmount;

    public WinningInfoDTO(int correctCount, WinningAmount winningAmount) {
        this.correctCount = correctCount;
        this.winningAmount = winningAmount;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getWinningAmount() {
        return winningAmount.amount();
    }
}
