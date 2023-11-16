package lotto.domain;

public enum WinningEnum {
    FIRST(6,2000000000),
    THIRD(5,1500000),
    FOuRTH(4, 50000),
    FIFTH(3, 5000);

    private int correctCount;
    private int winningAmount;

    WinningEnum(int correctCount, int winningAmount) {
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
