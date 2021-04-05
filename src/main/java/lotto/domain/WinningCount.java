package lotto.domain;

public class WinningCount {
    private int winningCount;

    public WinningCount() {
        this.winningCount = 0;
    }

    public WinningCount(int winningCount) {
        this.winningCount = winningCount;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public void plus(){
        this.winningCount++;
    }
}
