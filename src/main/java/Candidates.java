import java.util.ArrayList;

public class Candidates {
    private final ArrayList<Candidate> values;

    public Candidates() {
        values = new ArrayList<>();
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

    public long countByMatchCount(Lotto winning, MatchCount matchCount){
        MatchCounts matchCounts = new MatchCounts();

        for(Candidate candidate : this.values){
            matchCounts.add(candidate.match(winning));
        }

        return matchCounts.count(matchCount);
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
        if (matchCount.is(3)){ return 5000; }
        if (matchCount.is(4)){ return 50000; }
        if (matchCount.is(5)){ return 1500000; }
        if (matchCount.is(6)){ return 2000000000; }

        return 0;
    }
}
