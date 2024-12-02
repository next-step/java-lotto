import java.util.ArrayList;
import java.util.List;

public class CandidateRanks {
    private final List<CandidateRank> values;

    public CandidateRanks(){
        this(new ArrayList<>());
    }

    public CandidateRanks(List<CandidateRank> values) {
        this.values = values;
    }

    public void add(boolean bonusMatched, MatchCount matchCount) {
        this.values.add(new CandidateRank(bonusMatched, matchCount));
    }

    public void add(CandidateRank candidateRank) {
        this.values.add(candidateRank);
    }

    public long countFirst() {
        return this.values.stream().filter(v -> v.is(Rank.FIRST)).count();
    }

    public long countSecond() {
        return this.values.stream().filter(v -> v.is(Rank.SECOND)).count();
    }

    public long countThird() {
        return this.values.stream().filter(v -> v.is(Rank.THIRD)).count();
    }

    public long countFourth() {
        return this.values.stream().filter(v -> v.is(Rank.FOURTH)).count();
    }

    public long countFifth() {
        return this.values.stream().filter(v -> v.is(Rank.FIFTH)).count();
    }

    public double calcBenefitPercent() {
        double earn = 0;

        for (CandidateRank candidateRank : this.values) {
            earn += candidateRank.exchange();
        }

        double earnRatio = earn / (this.values.size() * 1000);
        earnRatio = Math.round(earnRatio * 100) / 100.0;

        return earnRatio;
    }
}
