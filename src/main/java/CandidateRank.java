public class CandidateRank {

    private final Rank rank;

    public CandidateRank(Lotto winning, LottoNumber bonusBall, Lotto candidateLotto) {
        this(candidateLotto.has(bonusBall), winning.match(candidateLotto));
    }

    public CandidateRank(boolean bonusMatched, MatchCount matchCount){
        this.rank = Rank.from(bonusMatched, matchCount);
    }

    public boolean is(Rank rank) {
        return this.rank == rank;
    }

    public int exchange() {
        return Rank.toMoney(rank);
    }
}
