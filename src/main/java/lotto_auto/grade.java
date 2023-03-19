package lotto_auto;

public enum grade {

    oneRank(20000000, 6),
    secondRank(30000000,5),
    thirdRank(1500000,5),
    fourthRank(50000,4),
    fifthRank(5000,3);

    private final int winningMoney;
    private final int matchCount;

    grade(int winningMoney, int matchCount) {
        this.winningMoney = winningMoney;
        this.matchCount = matchCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
