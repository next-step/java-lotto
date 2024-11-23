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

    public double calculateRatio(Lotto winning) {
        double earn = 0;

        for (Candidate candidate : this.values) {
            earn += calcMoney(candidate.match(winning));
        }

        double earnRatio = earn / (this.values.size() * 1000);
        earnRatio = Math.round(earnRatio * 100) / 100.0;

        return earnRatio;
    }

    private double calcMoney(MatchCount matchCount) {
        if (matchCount.is(3)){ return 5_000; }
        if (matchCount.is(4)){ return 50_000; }
        if (matchCount.is(5)){ return 1_500_000; }
        if (matchCount.is(6)){ return 2_000_000_000; }

        return 0;
    }
}
