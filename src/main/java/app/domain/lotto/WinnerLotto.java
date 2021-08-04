package app.domain.lotto;

public class WinnerLotto {
    private Lotto lotto;
    private LottoNum bonus;

    private WinnerLotto(Lotto lotto, LottoNum bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public static WinnerLotto of(Lotto lotto, LottoNum bonus){
        return new WinnerLotto(lotto, bonus);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public LottoNum getBonus() {
        return bonus;
    }
}
