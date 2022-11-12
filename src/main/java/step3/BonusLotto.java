package step3;

public class BonusLotto {
    private final int bonus;
    private final Lotto lotto;

    public BonusLotto(Lotto lotto, int bonus) {
        LottoValidator.isExistBonus(lotto, bonus);
        LottoValidator.checkLottoRange(bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public boolean checkBonus(Lotto lotto) {
        return lotto.checkBonus(bonus);
    }
}
