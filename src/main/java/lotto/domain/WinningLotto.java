package lotto.domain;

public class WinningLotto {

    private final Lotto lottoNumbers;
    private final LottoNumber bonus;

    public WinningLotto(final Lotto lottoNumbers, final LottoNumber bonus) {

        verify(lottoNumbers, bonus);

        this.lottoNumbers = lottoNumbers;
        this.bonus = bonus;
    }

    private void verify(Lotto lottoNumbers, LottoNumber bonus) {
        if (lottoNumbers.getLottoNumbers().contains(bonus)) {
            throw new IllegalArgumentException("winning lotto can't contain bonus number");
        }
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
