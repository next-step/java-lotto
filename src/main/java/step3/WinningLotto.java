package step3;

import java.util.Set;

public class WinningLotto extends Lotto {
    private final int bonus;

    public WinningLotto(Set<Integer> lotto, int bonus) {
        super(lotto);
        LottoValidator.isExistBonus(this, bonus);
        LottoValidator.checkLottoRange(bonus);
        this.bonus = bonus;
    }

    public boolean checkBonus(Lotto lotto) {
        return lotto.checkBonus(bonus);
    }
}
