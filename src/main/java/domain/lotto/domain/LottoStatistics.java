package domain.lotto.domain;

public class LottoStatistics {
    private int matchThreeCount;
    private int matchFourCount;
    private int matchFiveCount;
    private int matchSixCount;
    private int totalProfit;

    public LottoStatistics() {
        this.matchThreeCount = 0;
        this.matchFourCount = 0;
        this.matchFiveCount = 0;
        this.matchSixCount = 0;
    }

    public void calculate(int matchCount) {
        if (matchCount == Rank.FIRST.getCountOfMatch()) {
            this.matchSixCount++;
        }

        if (matchCount == Rank.SECOND.getCountOfMatch()) {
            this.matchFiveCount++;
        }

        if (matchCount == Rank.THIRD.getCountOfMatch()) {
            this.matchFiveCount++;
        }

        if (matchCount == Rank.FOURTH.getCountOfMatch()) {
            this.matchFourCount++;
        }

        if (matchCount == Rank.FIFTH.getCountOfMatch()) {
            this.matchThreeCount++;
        }
        totalProfit += Rank.winningMoneyOf(matchCount);
    }

    public int getTotalProfit() {
        return totalProfit;
    }

    public int getMatchThreeCount() {
        return matchThreeCount;
    }

    public int getMatchFourCount() {
        return matchFourCount;
    }

    public int getMatchFiveCount() {
        return matchFiveCount;
    }

    public int getMatchSixCount() {
        return matchSixCount;
    }
}
