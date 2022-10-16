package autoLotto;

public enum Match {
    THREE(3, 5000, 0),
    FOUR(4, 50000, 0),
    FIVE(5, 1500000, 0),
    SIX(6, 2000000000, 0);

    private int matchNum;
    private int winningAmount;
    private int countOfMatch;

    Match(int matchNum, int winningAmount, int countOfMatch) {
        this.matchNum = matchNum;
        this.winningAmount = winningAmount;
        this.countOfMatch = countOfMatch;
    }

    public int getMatchNum() {
        return matchNum;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public void countOfMatch() {
        this.countOfMatch++;
    }
}
