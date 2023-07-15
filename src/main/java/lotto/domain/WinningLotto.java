package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonus;

    public WinningLotto(final Lotto lotto, final LottoNumber bonus) {
        verify(lotto, bonus);

        this.lotto = lotto;
        this.bonus = bonus;
    }

    public WinningLotto(final List<Integer> lottoNumbers, final int bonus) {
        this(Lotto.createManualLotto(lottoNumbers), LottoNumber.of(bonus));
    }

    private void verify(final Lotto lotto, final LottoNumber bonus) {
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException("winning lotto can't contain bonus number");
        }
    }

    public Lotto getLotto() {
        return this.lotto;
    }

    public LottoNumber getBonus() {
        return this.bonus;
    }

    public LottoRank calculateRank(final Lotto lotto) {
        int match = this.lotto.countMatches(lotto);
        boolean isContainBonus = lotto.contains(bonus);
        return LottoRank.from(match, isContainBonus);
    }
}
