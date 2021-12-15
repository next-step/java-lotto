package step2.domain;

public class WinningInfo {
    private final long winningPrize;
    private final long winningCount;

    public WinningInfo(long winningPrize, long winningCount) {
        this.winningPrize = winningPrize;
        this.winningCount = winningCount;
    }

    public long calculatePrize() {
        return this.winningPrize * this.winningCount;
    }

    public long getWinningCount() {
        return winningCount;
    }

    public WinningInfo addWinningCount() {
        return new WinningInfo(this.winningPrize, this.winningCount + 1);
    }

}
