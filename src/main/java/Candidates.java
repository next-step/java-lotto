import java.util.ArrayList;
import java.util.List;

public class Candidates {
    private final List<Candidate> values;
    private final MatchCounts matchCounts;

    public Candidates() {
        this(new ArrayList<>());
    }

    public Candidates(List<Candidate> candidates) {
        this.values = candidates;
        this.matchCounts = new MatchCounts();
    }

    public void add(Lotto lotto) {
        this.add(new Candidate(lotto));
    }

    public void add(Candidate candidate) {
        this.values.add(candidate);
    }

    public int size() {
        return this.values.size();
    }

    public Candidates concat(Candidates other) {
        List<Candidate> combined = new ArrayList<>(this.values);
        combined.addAll(other.values);

        return new Candidates(combined);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Candidate candidate : values) {
            sb.append(candidate.toString());
            sb.append("\n");
        }

        return sb.toString();
    }

    public long countMatch(Lotto winning, MatchCount matchCount){
        this.matchCounts.clear();

        for(Candidate candidate : this.values){
            this.matchCounts.add(candidate.match(winning));
        }

        return this.matchCounts.count(matchCount);
    }

    public CandidateRanks calcRanks(Lotto winning, BonusBall bonusBall) {
        CandidateRanks ranks = new CandidateRanks();

        for(Candidate candidate : this.values){
            ranks.add(new CandidateRank(candidate.matchBonus(bonusBall), candidate.match(winning)));
        }

        return ranks;
    }
}
