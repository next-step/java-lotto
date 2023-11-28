package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class WinnerLotto {

    private final Lotto winnerLotto;
    private final Bonus bonus;

    public WinnerLotto(int bonusNumber, Integer ... winnerLotto) {
        this(new Lotto(winnerLotto), bonusNumber);
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinnerLotto that = (WinnerLotto) o;
        return Objects.equals(winnerLotto, that.winnerLotto) && Objects.equals(bonus, that.bonus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnerLotto, bonus);
    }
}
