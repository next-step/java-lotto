package lotto;

public class WinnerLotto {

    private final Number bonus;
    private final Numbers lottoNumbers;

    public WinnerLotto(String lottoNumbers, int bonus) {
        this.lottoNumbers = new Numbers(lottoNumbers);
        this.bonus = new Number(bonus);
    }

    public Rank calculateRank(Lotto boughtLotto) {
        int matchCount = countMatch(boughtLotto);
        boolean isBonusMatch = isBonusMatch(boughtLotto);

        return Rank.of(matchCount, isBonusMatch);
    }

    private boolean isBonusMatch(Lotto other) {
        return other.containsNumber(bonus);
    }

    private int countMatch(Lotto boughtLotto) {
        return lottoNumbers.countMatch(boughtLotto.getLottoNumbers());
    }

}
