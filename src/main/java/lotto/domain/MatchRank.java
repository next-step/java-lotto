package lotto.domain;

public class MatchRank {

    private Rank matchRank;

    public MatchRank() {
        this.matchRank = Rank.MISS;
    }

    public Rank getMatchRank() {
        return matchRank;
    }

    public void matching(Rank rank, int countMatchNumber) {
        if (rank.getCount() == countMatchNumber) {
            this.matchRank = rank;
        }
    }

    public void bonusMatching(boolean bonusBall) {
        if (matchRank.getCount() == 5 && !bonusBall) {
            this.matchRank = Rank.THIRD;
        }
    }
}
