package lotto.domain;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonus;

    public WinningLotto(Lotto lotto, LottoNumber bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public int matchCount(Lotto otherLotto) {
        return lotto.matchCount(otherLotto);
    }

    public boolean matchBonus(Lotto otherLotto) {
        return otherLotto.contains(bonus);
    }
}
