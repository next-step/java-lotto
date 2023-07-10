package lotto.domain;

public class WinningLotto {

    private final Lotto lottoNumbers;
    private final LottoNumber bonus;

    public WinningLotto(final Lotto lottoNumbers, final LottoNumber bonus) {
        this.lottoNumbers = lottoNumbers;
        this.bonus = bonus;
    }

    public Lotto getLottoNumbers() {
        return this.lottoNumbers;
    }

    public LottoNumber getBonus() {
        return this.bonus;
    }

    public LottoRank calculateRank(Lotto lotto) {
        Long match = this.lottoNumbers.countMatches(lotto);
        boolean isContainBonus = lotto.getLottoNumbers().contains(bonus);
        return LottoRank.from(match, isContainBonus);
    }
}
