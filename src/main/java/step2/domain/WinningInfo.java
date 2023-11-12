package step2.domain;

public class WinningInfo {
    private final int matchCount;
    private final int winningMoney;
    private final int winningCount;

    public WinningInfo(int matchCount, int winningMoney, int winningCount) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
        this.winningCount = winningCount;
    }

    @Override
    public String toString() {
        return "WinningInfo{" +
                "matchCount=" + matchCount +
                ", winningMoney=" + winningMoney +
                ", winningCount=" + winningCount +
                '}';
    }

    public int matchCount() {
        return matchCount;
    }

    public int winningMoney() {
        return winningMoney;
    }

    public int winningCount() {
        return winningCount;
    }

    public int earningMoney(){
        return winningMoney * winningCount;
    }
}
