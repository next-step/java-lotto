import java.util.ArrayList;

public class Candidates {
    private final ArrayList<Candidate> values;

    public Candidates() {
        values = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        this.values.add(new Candidate(lotto));
    }

    public int size() {
        return this.values.size();
    }

    public double calculateRatio(Lotto winning) {
        double earn = 0;

        for (Candidate candidate : this.values) {
            earn += candidate.getMoney(winning);
        }

        double earnRatio = earn / (this.values.size() * 1000);
        earnRatio = Math.round(earnRatio * 100) / 100.0;

        return earnRatio;
    }


}
