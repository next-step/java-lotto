public class Candidate {
   private final Lotto lotto;

    public Candidate(Lotto lotto) {
        this.lotto = lotto;
    }

    public double getMoney(Lotto other) {
        MatchCount matchCount = this.lotto.match(other);

        if (matchCount.is(3)){ return 5000; }
        if (matchCount.is(4)){ return 50000; }
        if (matchCount.is(5)){ return 1500000; }
        if (matchCount.is(6)){ return 2000000000; }

        return 0;
    }
}
