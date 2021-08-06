package app.domain.lotto;

public class WinnerLotto {
    private static final String ERROR_MSG = "보너스 번호가 포함되어 있습니다.";

    private Lotto lotto;
    private LottoNum bonus;

    private WinnerLotto(Lotto lotto, LottoNum bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public static WinnerLotto of(Lotto lotto, LottoNum bonus) {
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException(ERROR_MSG);
        }
        return new WinnerLotto(lotto, bonus);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public LottoNum getBonus() {
        return bonus;
    }
}
