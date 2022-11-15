package step3;

import java.util.Set;

public class WinningLotto extends Lotto {
    private final int bonus;

    public WinningLotto(Set<Integer> lotto, int bonus) {
        super(lotto);
        validateBonus(bonus);
        this.bonus = bonus;
    }

    private void validateBonus(int bonus) {
        if (this.isExist(bonus)) {
            throw new IllegalArgumentException("보너스 번호는 지난 주 당첨 번호와 중복될 수 없습니다.");
        }
        this.checkLottoRange(bonus);
    }

    public boolean checkBonus(Lotto lotto) {
        return lotto.isExist(bonus);
    }
}
