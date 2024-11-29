public class Candidate {
   private final Lotto lotto;

    public Candidate(Lotto lotto) {
        this.lotto = lotto;
    }

    public MatchCount match(Lotto other) {
        return this.lotto.match(other);
    }

    @Override
    public String toString() {
        return "[" + lotto.toString() + "]";
    }

    public boolean matchBonus(LottoNumber bonusBall) {
        return this.lotto.has(bonusBall);
    }
}
