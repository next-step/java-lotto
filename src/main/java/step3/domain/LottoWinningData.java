package step3.domain;

public class LottoWinningData {
    private final int matchCount;
    private final int prize;
    private final int winningCount;

    public LottoWinningData(WinningType winningType, int winningCount) {
        this.matchCount = winningType.getMatchCount();
        this.prize = winningType.getPrize();
        this.winningCount = winningCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public int getWinningCount() {
        return winningCount;
    }
}
