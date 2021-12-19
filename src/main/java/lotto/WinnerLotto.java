package lotto;

public class WinnerLotto extends Lotto {

    private final Number bonus;

    public WinnerLotto(String lottoNumbers, int bonus) {
        super(lottoNumbers);
        this.bonus = new Number(bonus);
    }

    public Rank calculateRank(Lotto other) {
        int matchCount = this.countMatch(other);
        boolean isBonusMatch = isBonusMatch(other);

        return Rank.of(matchCount, isBonusMatch);
    }

    private boolean isBonusMatch(Lotto other) {
        return other.containsNumber(bonus);
    }

}
