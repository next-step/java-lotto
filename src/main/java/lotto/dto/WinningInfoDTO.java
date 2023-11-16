package lotto.dto;

public class WinningInfoDTO {
    private int correctCount;
    private int winningAmount;

    public WinningInfoDTO(int correctCount, int winningAmount) {
        this.correctCount = correctCount;
        this.winningAmount = winningAmount;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
