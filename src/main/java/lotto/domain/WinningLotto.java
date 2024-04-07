package lotto.domain;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonus ;

    public WinningLotto(Lotto lotto, LottoNumber bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public LottoNumber getBonus() {
        return bonus;
    }
}
