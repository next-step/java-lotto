package lotto;

public class WinningLotto {
    private int matchCount;
    private int winningAmount;

    public WinningLotto(int matchCount, int winningAmount) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
