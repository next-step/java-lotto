public class CandidateRank {

    private final Rank rank;

    public CandidateRank(boolean bonusMatched, MatchCount matchCount){
        this.rank = this.convertRank(bonusMatched, matchCount);
    }

    public CandidateRank(Lotto winning, BonusBall bonusBall, Lotto candidateLotto) {
        this.rank = this.calcRank(winning, bonusBall, candidateLotto);
    }

    public boolean is(Rank rank) {
        return this.rank == rank;
    }

    private Rank calcRank(Lotto winning, BonusBall bonusBall, Lotto candidateLotto) {
        return this.convertRank(candidateLotto.has(bonusBall), winning.match(candidateLotto));
    }

    private Rank convertRank(boolean bonusMatched, MatchCount matchCount) {
        if (matchCount.is(6)) {
            return Rank.FIRST;
        }
        if(matchCount.is(5) && bonusMatched) {
            return Rank.SECOND;
        }
        if (matchCount.is(5)) {
            return Rank.THIRD;
        }
        if (matchCount.is(4)) {
            return Rank.FOURTH;
        }
        if (matchCount.is(3)) {
            return Rank.FIFTH;
        }

        return Rank.UNRANKED;
    }
}
