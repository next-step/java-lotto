package lotto.domain;

import static lotto.domain.Rank.valueOf;

public class WinLotto {

    private final Lotto lotto;

    private final Number bonus;

    public WinLotto(Lotto lotto, Number bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Lotto lotto() {
        return lotto;
    }

    public Number bonus() {
        return bonus;
    }

    public Rank calculateRank(Lotto lotto) {
        int winCount = lotto.calculateWinCount(this.lotto);
        boolean isBonus = lotto.contains(bonus);
        return valueOf(winCount, isBonus);
    }

}
