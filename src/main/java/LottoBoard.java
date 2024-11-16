import java.util.ArrayList;

public class LottoBoard {

    private Lotto winning;
    private ArrayList<Lotto> candidates;

    public LottoBoard() {
        this.candidates = new ArrayList<>();
    }

    public void registerWinning(Lotto winning) {
        this.winning = winning;
    }

    public void addCandidates(Lotto cand) {
        this.candidates.add(cand);
    }

    public double calculateBenefit() {
        ArrayList<MatchCount> matchCounts = new ArrayList<>();

        for (Lotto candidate : candidates) {
            matchCounts.add(winning.match(candidate));
        }

        double earn = 0;

        for (MatchCount matchCount : matchCounts) {
            if (matchCount.is(3)){
                earn += 5000;
            }

            if(matchCount.is(4)){
                earn += 50000;
            }

            if(matchCount.is(5)){
                earn += 1500000;
            }

            if(matchCount.is(6)) {
                earn += 2000000000;
            }
        }

        double benefit = earn / (this.candidates.size() * 1000);
        benefit = Math.round(benefit * 100) / 100.0;

        return benefit;
    }
}
