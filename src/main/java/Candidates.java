import java.util.ArrayList;
import java.util.List;

public class Candidates {
    private final List<Candidate> values;

    public Candidates() {
        this(new ArrayList<>());
    }

    public Candidates(List<Candidate> candidates) {
        this.values = candidates;
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

    public CandidateRanks calcRanks(Lotto winning, LottoNumber bonusBall) {
        CandidateRanks ranks = new CandidateRanks();

        for(Candidate candidate : this.values){
            ranks.add(new CandidateRank(candidate.matchBonus(bonusBall), candidate.match(winning)));
        }

        return ranks;
    }
}
