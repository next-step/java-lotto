package lotto.domain;

import java.util.Objects;

public class WinningCondition {
    private final Lotto winningLotto;
    private final LottoNo bonus;

    public WinningCondition(Lotto winningLotto, LottoNo bonus) {
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    Rank getRank(Lotto lotto) {
        return Rank.valueOf(
                lotto.getCountOfMatch(winningLotto)
                , lotto.contains(bonus)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningCondition that = (WinningCondition) o;
        return Objects.equals(winningLotto, that.winningLotto) &&
                Objects.equals(bonus, that.bonus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto.toString(), bonus);
    }
}
