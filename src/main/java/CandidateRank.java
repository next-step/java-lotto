public class CandidateRank {

    private Rank rank;

    public CandidateRank(MatchCount matchCount) {
        this.rank = this.convertRank(matchCount);
    }

    public CandidateRank(Lotto winning, Lotto candidateLotto) {
        this.rank = this.calcRank(winning, candidateLotto);
    }

    public boolean is(Rank rank) {
        return this.rank == rank;
    }

    private Rank calcRank(Lotto winning, Lotto candidateLotto) {
        return this.convertRank(winning.match(candidateLotto));
    }

    private Rank convertRank(MatchCount matchCount) {
        if (matchCount.is(3)) {
            return Rank.FIFTH;
        }
        if (matchCount.is(4)) {
            return Rank.FOURTH;
        }
        if (matchCount.is(5)) {
            return Rank.THIRD;
        }
        // TODO: bonus
        if (matchCount.is(6)) {
            return Rank.FIRST;
        }

        return Rank.UNRANKED;
    }
}
