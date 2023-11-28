package lotto.domain;

import java.util.Set;

public class WinnerLotto {

    private final Lotto winnerLotto;
    private final Bonus bonus;

    public WinnerLotto(Lotto winnerLotto, int bonusNumber) {
        this.winnerLotto = winnerLotto;
        this.bonus = new Bonus(bonusNumber, winnerLotto);
    }

    public int countOfMatch(Set<LottoNumber> lotto) {
        return this.winnerLotto.countOfMatch(lotto);
    }

    public boolean containsBonus(Set<LottoNumber> lotto) {
        return this.bonus.containsBonus(lotto);
    }
}
